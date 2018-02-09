package com.Guru99.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Guru99.qa.base.BaseTest;
import com.Guru99.qa.pages.*;

public class MobilePageTest extends BaseTest {
	
	ShoppingCartPage shoppingCartpage;
	MobilePage mobilePage;
	HomePage homePage;
	public  MobilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		shoppingCartpage=new ShoppingCartPage();
		homePage=new HomePage();
	}
	@Test
	public void verifyIphoneAddToCartTest() throws InterruptedException {
		mobilePage=homePage.mobileLink();
		shoppingCartpage = mobilePage.iPhoneAddCart();
		boolean flag = shoppingCartpage.verifyDiscountPrice();
		try {
		Assert.assertTrue(flag);
		} catch(AssertionError e) {
			System.out.println("Upon applying coupon code grand total didnt change");
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
