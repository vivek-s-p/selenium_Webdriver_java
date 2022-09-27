package seleniumWebDriverCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboardActions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		

		//openBrowser();

		//mouseHover();

		//dragAndDrop();

		//keyboardActions();

		//closeBrowser();

	}

	static void mouseHover() throws InterruptedException {

		driver.get("https://www.google.com/");

		Actions mouseEvent= new Actions(driver);
		mouseEvent.moveToElement(driver.findElement(By.name("q"))).build().perform();		
		Thread.sleep(800);
		mouseEvent.moveToElement(driver.findElement(By.xpath("//div[@aria-label=\"Search by voice\"]"))).build().perform();		
		Thread.sleep(800);

	}

	static void dragAndDrop() throws InterruptedException {


		//Using Action class for drag and drop.		
		Actions mouseEvent=new Actions(driver);	

		driver.get("http://demo.guru99.com/test/drag_drop.html");
		//Element which needs to drag.    		
		WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	

		//Element on which need to drop.		
		WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					

		//Dragged and dropped.		
		mouseEvent.dragAndDrop(From, To).build().perform();
		Thread.sleep(800);
		Thread.sleep(800);

		//Another way.
		mouseEvent.clickAndHold(driver.findElement(By.xpath("//section[@id='g-container-main']//li[4]/a")))
		.moveToElement(driver.findElement(By.xpath("//ol[@id='amt7']/li")))
		.release().build().perform();

		Thread.sleep(800);

		/**** Other mouse Actions *********
		contextClick()
		doubleClick()
		moveByOffset(x-offset, y-offset)
		 ***********************************/

	}

	static void keyboardActions() throws InterruptedException {


		driver.get("http://www.facebook.com/");
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername)
				.contextClick()
				.click()
				.build();

		seriesOfActions.perform() ;
		
		Thread.sleep(800);
		
		driver.findElement(By.id("reg_pages_msg")).click();
		
		builder.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.build().perform();
		
		Thread.sleep(800);
		
		///String selectAll = Keys.chord(Keys.CONTROL, "a");
		//driver.findElement(By.id("reg_pages_msg")).sendKeys(selectAll);

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
