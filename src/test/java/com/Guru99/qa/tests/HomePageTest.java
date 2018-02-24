package com.Guru99.qa.tests;




import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Guru99.qa.base.BaseTest;
import com.Guru99.qa.pages.HomePage;
import com.Guru99.qa.pages.MobilePage;
import com.Guru99.qa.util.TestUtil;

public class HomePageTest extends BaseTest {
	
	HomePage hp;
	public HomePageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialisation();
		hp=new HomePage();
	}
	
	@Test(priority=1)
	public void homepageTitleTest() {
		String title = hp.validateTitle();
		Assert.assertEquals(title, TestUtil.TITLE_HOMEPAGE);
	}
	@Test(priority=2,enabled=false)
	public void logoGuru99Test() {
		boolean flag = hp.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void mobileLinkTest() {
		MobilePage mp=hp.mobileLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
