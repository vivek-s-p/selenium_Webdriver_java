package seleniumWebDriverCommands;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindBrokenLinks {
	static WebDriver driver;
	public static void main(String[] args) {
			
		openBrowser();
		findBrokenLinks("http://www.google.com/");
		closeBrowser();

	}

	public static void findBrokenLinks(String url) {

		driver.get(url);
		System.out.println(driver.getTitle());
		List<WebElement> allaTags=driver.findElements(By.tagName("a"));
		System.out.println(allaTags.size());

		List <String> allurls= new ArrayList<String>();

		for(WebElement e:allaTags) {
			
			String getUrl=e.getAttribute("href");

			if(!(getUrl==null || getUrl.isEmpty() || getUrl.contains("mailto"))){

				allurls.add(getUrl);
				//System.out.println(getUrl);
				performLinkCheck(getUrl);

			}
		}
		
		allurls.parallelStream().forEach(e -> performLinkCheck(e)); //For quicker execution 
	}

	public static void performLinkCheck(String link) {
		try {
			URL url=new URL(link);
			HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
			urlConnection.setConnectTimeout(5000);
			urlConnection.connect();

			if(urlConnection.getResponseCode()>=400) {

				System.out.println("Broken link-->> "+ link +" "+ urlConnection.getResponseMessage());

			}else {

				System.out.println("link -->> "+ link +" "+ urlConnection.getResponseMessage());
			}


		} catch (IOException e) {

			e.printStackTrace();
		}



	}

	public static void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\\\Installed Apps\\\\chromedriver.exe"); 

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	public static void closeBrowser() {

		driver.close();

	}

}
