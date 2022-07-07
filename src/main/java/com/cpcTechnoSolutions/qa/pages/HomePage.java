package com.cpcTechnoSolutions.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpcTechnoSolutions.qa.base.TestBase;
import com.cpcTechnoSolutions.qa.utils.TestUtils;

public class HomePage extends TestBase {
	
	//page library 
	@FindBy(xpath="//div//h2[contains(text(),'Welcome to ')]//span[@class='welcome-line text-Capitalize']")
	WebElement DashboardText;
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	WebElement changePassword;

	@FindBy(xpath="//input[@type='button']")
	WebElement closebtn;
	
	@FindBy(xpath="(//a[@class='more'])[1]")
	WebElement Employees;
	
	@FindBy(xpath="(//a[@class='more'])[2]")
	WebElement Clients;
	
	@FindBy(xpath="(//a[@class='more'])[3]")
	WebElement Projects;
	
	@FindBy(xpath="//a/span[contains(text(),'Admin')]")
	WebElement Admin;
	
	
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectDashboardText()

	{
		return DashboardText.isDisplayed();
	}
	
	public WebElement clickOnChangePassword()
	{
		return changePassword;
		
	}
	public WebElement closeChangePassword()
	{
		return closebtn;
	}
	
	public EmployeesPage employeesViewMore()
	{
		 Employees.click();
		 return new EmployeesPage();
		 
	}
	public ClientsPage clientsViewMore()
	{
		Clients.click();
		return new ClientsPage();
	}
	
	public ProjectsPage projectsViewMore()
	{
		Projects.click();
		return new ProjectsPage();
	}
	
	public AdminPage Admin()
	{
		Admin.click();
		
		return new AdminPage();
		
	}
	
	
	
	
}
