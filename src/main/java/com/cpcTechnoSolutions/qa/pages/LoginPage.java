package com.cpcTechnoSolutions.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpcTechnoSolutions.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	/*
	 * page factory-it is a class provided by selenium webdriver to support page object design pattern
	 * initElements-it is used to initialize web elements
	 * @findBy -An annotation used in pagefactory to locate and declare webelements using different locators
	 *  
	 */
	
	@FindBy(xpath="//input[@id='login-username']")
//@CacheLookup//This annotation ,when applied over a webelement ,instructs Selenium to keep a cache of the webelement instead of searching for the webelement everytime for the webelement everytime from the webpage .this help us save a lot of time
//and it will increase the perfomance and save the time
	WebElement username;
	
	@FindBy(xpath="//input[@id='login-password']")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div[3]/div/label")
	WebElement RememberMe;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CPCLogo;
	
	public LoginPage()
	{                                              //instead of this we can also loginpage.class
		PageFactory.initElements(driver, this);//this means pointig to the current class objects 
		
	}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateCPCLogo()
	{
		return CPCLogo.isDisplayed();
	}
	
	public WebElement ValidateRememberMe()
	{
		return RememberMe;
		 
	}
	public HomePage validateLoginPage(String Username, String Password)
	{
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
}
