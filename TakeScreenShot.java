package seleniumWebDriverCommands;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenShot {
	static WebDriver driver;

	@Test
	public static void loadPage() {

		driver.get("http://www.google.com");
		driver.findElement(By.className("hello"));

	}



	@AfterMethod
	public static void takeScreenShot(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus())
		{
			try {
				TakesScreenshot tc= (TakesScreenshot) driver;
				File source =tc.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File ("E:\\WebDriverActivity\\WebDriverWithJavaAllOperations\\Screenshots\\"+ (int)(Math.random()*1000)+".png"));
				System.out.println("Screenshot taken");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@BeforeMethod
	public static void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\\\Installed Apps\\\\chromedriver.exe"); 

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}
	@AfterTest
	public static void closeBrowser() {

		driver.close();

	}

}
