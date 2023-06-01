package com.IPT_Git_Task_May.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected static WebDriver driver;
	static Actions a;
	JavascriptExecutor js;
	
	
	public void launchurl(String url)   {
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver","C:\\Users\\Braver Robotics\\eclipse-workspace\\Selenium\\driver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static boolean elementDisplayed(WebElement element)   {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	
	public static boolean elementEnabled(WebElement element)   {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	
	public static void clickOnElement(WebElement element)   {
				element.click();
	}
	
	public static void inputVaue(WebElement element, String value)   {
				element.sendKeys(value);
	}
	
	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void expWaitClick(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static void simpleAlert()   {
		Alert simple = driver.switchTo().alert();
		simple.accept();
	}
	
	public static void confirmAlert(String action)   {
		if(action.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if(action.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
	}
	
	public static void promptAlert(String value) {
			Alert confirm = driver.switchTo().alert();
			confirm.sendKeys(value);
	}
	
	public static void screenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Braver Robotics\\eclipse-workspace\\nykaa\\Screenshots\\"+fileName+".png");
		Files.copy(src, dest);
	}
	
	public static void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).build().perform();;
	}
	
	public static void mouseHover(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	public static void dragDrop(WebElement src,WebElement dest) {
		a = new Actions(driver);
		a.dragAndDrop(src, dest).build().perform();
	}
	
	public void scrollByValue(int x, int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void clickUsingJSE(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
		
	public void scrollIntoElement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scroIntoView();", element);
	}
	
	public void inputUsingJSE(String id, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').value('"+value+"');");
	}
	
	public void JSScrollBottom() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}
	
	public void JSSendKeys(String id, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').value('"+value+"');");
	}

	public static void dropDown(String option,WebElement element,String value) {
		Select s = new Select(element);
		if(option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		} else if(option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if(option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}
	
	public void switchToFrame(String option, String value) {
		if(option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			driver.switchTo().frame(index);
		} else if(option.equalsIgnoreCase("id")||option.equalsIgnoreCase("name")) {
			driver.switchTo().frame(value);
		}
	}
	
	public void switchFrameUsingElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchWindow(int index) {
		Set<String> allid = driver.getWindowHandles();
		List<String> tabidlist = new LinkedList<>(allid);
		driver.switchTo().window(tabidlist.get(index));
	}
	
	public void keyPress(int noOfTimes) throws AWTException {
		Robot r = new Robot();
		for(int i=0;i<noOfTimes;i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}