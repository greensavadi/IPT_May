package com.IPT_Git_Task_May.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.IPT_Git_Task_May.base.BaseClass;

public class GoibiboPom extends BaseClass {
		
	public GoibiboPom(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//span[@class=\"complete\"]")
	private WebElement date;
	
	@FindBy(xpath = "//span[@class=\"black\"]") 
	private WebElement BeforeSixAm;
	
	@FindBy(xpath = "//span[text()='6AM - 12PM']")
	private WebElement sixAmToTwelvePm;
	
	@FindBy(xpath = "//span[text()='12PM - 6PM']")
	private WebElement twelvePmToSixPm;
	
	@FindBy(xpath = "//span[text()='After 6PM']") 
	private WebElement afterSixPm;
	
	@FindBy(xpath = "(//button)[4]")
	private WebElement viewFares;
	
	@FindBy(xpath = "(//input[@type='button'])[3]")
	private WebElement familyFare;
    
	
	public WebElement getDate() {
		return date;
	}
	
	public WebElement getBeforeSixAm() {
		return BeforeSixAm;
	}

	public WebElement getSixAmToTwelvePm() {
		return sixAmToTwelvePm;
	}

	public WebElement getTwelvePmTosixPm() {
		return twelvePmToSixPm;
	}

	public WebElement getAfterSixPm() {
		return afterSixPm;
	}

	public WebElement getViewFares() {
		return viewFares;
	}

	public WebElement getFamilyFare() {
		return familyFare;
	}

}
