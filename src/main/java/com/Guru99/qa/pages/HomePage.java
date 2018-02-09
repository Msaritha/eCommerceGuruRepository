package com.Guru99.qa.pages;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.BaseTest;
//import com.Guru99.qa.util.TestUtil;

public class HomePage extends BaseTest {

	//Page Factory - Object Repository
	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement mobileLink;
	
	@FindBy(xpath="//a[text()='TV']")
	WebElement TVLink;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")
	WebElement myAccountLink;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cartLink;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/a/img[1]")
	WebElement logo;
	
	@FindBy(xpath="//h2[contains(text(),'demo site')]")
	WebElement homePageText;
//	
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public boolean validateLogo() {
		return (logo.isDisplayed());
	}
	public String validateTitle() {
		return (driver.getTitle());
	}
	public MobilePage mobileLink() {
		mobileLink.click();
		return new MobilePage();
	}
	
}
