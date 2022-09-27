package seleniumWebDriverCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownActivities {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		selectDropDownOperation();
		multiSelectDropDownOperation();
		dynamicDropDownOperation();

	}

	public static void selectDropDownOperation() throws InterruptedException {

		openBrowser();

		driver.get("http://demo.guru99.com/test/newtours/register.php");

		Select dropDown = new Select(driver.findElement(By.xpath("//select[@name='country']")));

		/*** Following 3 Method can be use for selecting the value from dropdown ***/
		dropDown.selectByIndex(0);
		Thread.sleep(800);
		dropDown.selectByValue("AUSTRALIA");
		Thread.sleep(800);
		dropDown.selectByVisibleText("AZERBAIJAN");

		/***If provided option is not valid= Exception-NoSuchElementException: Cannot locate element with text: AZERBAIJAN***/

		/**Deselection is only for multi-select if tried below exception will be displayed***/
	
		//dropDown.deselectByVisibleText("AZERBAIJAN");
		
		/***Exception java.lang.UnsupportedOperationException: You may only deselect options of a multi-select***/
		Thread.sleep(800);
		closeBrowser();

	}

	public static void multiSelectDropDownOperation() throws InterruptedException {

		openBrowser();

		driver.get("https://output.jsbin.com/osebed/2");

		Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='fruits']")));
		/***To select value***/
		dropDown.selectByIndex(0);
		dropDown.selectByValue("banana");
		dropDown.selectByVisibleText("Orange");
		Thread.sleep(800);
		/***To deselect value***/
		dropDown.deselectByIndex(0);
		dropDown.deselectByValue("banana");
		dropDown.deselectByVisibleText("Orange");
		dropDown.deselectAll();

		System.out.print(dropDown.isMultiple()); //isMultiple Method is to check the drop-down is multi-select or not

		/***Exception = NoSuchElementException: If Cannot locate element with text: AZERBAIJAN***/

		closeBrowser();

	}

	public static void dynamicDropDownOperation() throws InterruptedException {

		openBrowser();

		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		List<WebElement> allOptions=new ArrayList<WebElement>();
		
		 allOptions = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//child::li"));

		for (WebElement clickThisOption : allOptions) {

			System.out.println(clickThisOption.getText());

			if (clickThisOption.getText().contains("Charles de Gaulle Airport")) {

				clickThisOption.click();
				break;

			}

			System.out.println("No match found");

		}
		Thread.sleep(800);
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
