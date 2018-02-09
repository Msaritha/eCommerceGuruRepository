package com.Guru99.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Guru99.qa.util.TestUtil;

import org.openqa.selenium.WebDriver;

public class BaseTest {

	public static WebDriver driver;
	static Properties prop;
	
	public BaseTest()
	{
		try	{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\sarit\\eclipse-workspace\\"
					+ "Guru99eCommerceTest\\src\\main\\java\\com\\Guru99\\qa\\config\\Config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e)	{
			e.printStackTrace();
		} catch(IOException e) 	{
			e.printStackTrace();
		}
	}
	
	public static void initialisation()
	{
		String browserName=prop.getProperty("browser");
		String baseURL=prop.getProperty("url");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C://IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C://geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
}
