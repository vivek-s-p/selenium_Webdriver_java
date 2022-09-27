package seleniumWebDriverCommands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleiFrames {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		openBrowser();
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		List <WebElement> iframes = driver.findElements(By.tagName("iframe"));
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());//To identify the number of frame available
		
		for(WebElement frameName:iframes) {
			
			System.out.println(frameName.getAttribute("name"));//for loop is to get frame name or id
			
		}
		
		 driver.switchTo().frame("a077aa5e"); //iframe id, name or index can be provided
		 /**NoSuchFrameException - If the frame cannot be found**/
		 
		 driver.switchTo().defaultContent(); // To move back to the main
		 driver.switchTo().parentFrame(); //To move back to the parent frame
		
		 closeBrowser();
		
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
