	package com.cpcTechnoSolutions.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpcTechnoSolutions.qa.base.TestBase;
import com.cpcTechnoSolutions.qa.pages.HomePage;
import com.cpcTechnoSolutions.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginpage;//created the loginpage class object to call the elements
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();//it will call the parent class constructor i.e.,from TestBase
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();//initialize the driver
		loginpage=new LoginPage();
	}

	
	/*@Test(dataProvider="LoginData")
	public void loginTestData(String username,String password,String expected)
	{
		System.out.println(username+password+expected);
	}
	
	@DataProvider(name="LoginData")
	public String [][]getData()
	{
		String loginData[][]= {{"cpctechnosolutions","Test@123","Valid"},
				{"cpctechnosolutions","Test@333","InValid"},
				{"cpctechnolutions","Test@123","InValid"},
				{"cpctechnosolutions","test@#123","InValid"}};
		return loginData;
	}*/
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		System.out.println("title of the page"+title);
		Assert.assertEquals(title, "CPCTechno Solutions-Login");
	}
	
	@Test(priority=2)
	public void CPClogoImageTest()
	{
		boolean flag=loginpage.validateCPCLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void RememberMeClick()
	{
		loginpage.ValidateRememberMe().click();
		
	}
	@Test(priority=4)
	public void loginTest()
	{
		homepage=loginpage.validateLoginPage(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
