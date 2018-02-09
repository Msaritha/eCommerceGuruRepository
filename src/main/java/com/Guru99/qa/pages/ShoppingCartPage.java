package com.Guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.BaseTest;
import com.Guru99.qa.util.TestUtil;

public class ShoppingCartPage extends BaseTest{

	@FindBy(xpath="//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span")
	WebElement proceedToCheckOut;
	
	@FindBy(id="coupon_code")
	WebElement couponCode;
	
	@FindBy(xpath="//span[text()='Apply']")
	WebElement applyLink;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span")
	WebElement discountAmount;
	
	@FindBy(xpath="//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span")
	WebElement grandTotalAmt;
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyDiscountPrice() {
		String bPrice=grandTotalAmt.getText();
		couponCode.sendKeys(TestUtil.COUPON_CODE);
		applyLink.click();
		
		String aPrice=grandTotalAmt.getText();
		if(bPrice.equals(aPrice)) {
			System.out.println("Price didnot change");
			return false;
		}
		else {
			System.out.println("Price changed");
			return true;
		}
			
	}
	
	
}
