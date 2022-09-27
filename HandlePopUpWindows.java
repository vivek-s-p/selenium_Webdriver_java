package seleniumWebDriverCommands;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePopUpWindows {

	static WebDriver driver;

	public static void main(String[] args) {

		openBrowser();

		handlePopUpWindows();

		closeBrowser();

	}

	static void handlePopUpWindows() {
			
		driver.get("http://demo.guru99.com/popup.php");			
		driver.manage().window().maximize();		

		System.out.println("Title of parent window ->"+driver.getTitle());
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
		
		//Get current window
		String MainWindow=driver.getWindowHandle();	
		
		//To handle all new opened window.				
		Set<String> storeAllWindows=driver.getWindowHandles();

		Iterator<String> loopStoredWindows=storeAllWindows.iterator();		

		while(loopStoredWindows.hasNext())			
		{		
			String ChildWindow=loopStoredWindows.next();		

			if(!MainWindow.equalsIgnoreCase(ChildWindow))			
			{    		

				// Switching to Child window
				driver.switchTo().window(ChildWindow);	

				System.out.println("Title of child window ->"+driver.getTitle());

				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                		
				driver.findElement(By.name("btnLogin")).click();			

				// Closing the Child Window.
				driver.close();		
			}		
		}		
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);
		System.out.println("Title of parent window ->"+driver.getTitle());
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
