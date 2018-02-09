package com.Guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.BaseTest;

public class MobilePage extends BaseTest {

	@FindBy(xpath="//a[text()='IPhone']")
	WebElement iphoneLink;
	
	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button/span/span")
	WebElement iPhoneAddtoCartLink;
	
	@FindBy(xpath="//a[text()='Sony Xperia']")
	WebElement sonyXperiaLink;
	
	@FindBy(xpath="//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']")
	WebElement sonyXperiaAddToCartLink;
	
	public MobilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ShoppingCartPage iPhoneAddCart() throws InterruptedException {
		iPhoneAddtoCartLink.click();
		Thread.sleep(2000);
		return new ShoppingCartPage();
	}
	
	
	
}
