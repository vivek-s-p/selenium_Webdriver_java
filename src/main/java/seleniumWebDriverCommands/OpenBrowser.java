package seleniumWebDriverCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenBrowser {
	
	public static WebDriver driver;
	
	public static void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "E:\\\\Installed Apps\\\\chromedriver.exe");
		
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

	public static void main(String[] args) {

	}

}
