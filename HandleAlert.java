package seleniumWebDriverCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {
	
	 static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		openBrowser();
		
		handleAlert();
		
		closeBrowser();
	
	}
	
	static void handleAlert() throws InterruptedException {

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.cssSelector("input.signinbtn")).click();
		/**If alert not handled;Exception-UnhandledAlertException: unexpected alert open: {Alert text : Please enter a valid user name**/

		Thread.sleep(800);		

		/**Methods to handle alert**/

		System.out.println("Captured text from the Alert -> " +driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();
		
		//driver.switchTo().alert().dismiss();
		//driver.switchTo().alert().getText();
	
	}
	
	
	
	public static void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\\\Installed Apps\\\\chromedriver.exe"); 

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	public static void closeBrowser() {

		driver.close();

	}
	
	
	
	

}
