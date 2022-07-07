package com.cpcTechnoSolutions.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cpcTechnoSolutions.qa.utils.TestUtils;
import com.cpcTechnoSolutions.qa.utils.webEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;//it is used to show the action in the console
	public static webEventListener eventListener;
	
	
	public TestBase()
	{
		
		try {
			prop=new Properties();
			FileInputStream fi=new FileInputStream("D:\\KaranSelenium\\framework\\src\\main\\java\\com\\"
					+ "cpcTechnoSolutions\\qa\\config\\config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();//it is used to tell the line and class which line exception is thrown
		}
		
	}
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			   driver=new ChromeDriver();
			
		}else if(browserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			    driver=new FirefoxDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		//Now create object of Eventlistenerhandler to register it with eventfiringwebdriver
		eventListener=new webEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("Url"));
		
	}

}
