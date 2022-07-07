package com.cpcTechnoSolutions.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpcTechnoSolutions.qa.base.TestBase;

public class EmployeesPage extends TestBase{
	
	@FindBy(xpath="//div[contains(text(),' List of Employees' )]")
	WebElement ListOfEmployees;
	
	@FindBy(xpath="//input[@type='text' and @aria-controls='big_table']")
	WebElement SearchEmployees;
	
	@FindBy(xpath="//a[@class='btn yellow-gold']")
	WebElement DashboardEmployees;
	
	@FindBy(xpath="//select[@name='big_table_length']")
	WebElement DropdownshowEmployees;
	
	//Intialize the pageObjects
	public EmployeesPage()
	{
		PageFactory.initElements(driver, this);//this is used to initailize the current class objects
		
	}
	public String validateEmployeesPageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean validateListOfEmployee()
	{
		return ListOfEmployees.isDisplayed();
		
	}
	public String validateListOfEmployeeText()
	{
		
		return ListOfEmployees.getText();
	}
	public WebElement validateSearchEmployees()
	{
		return SearchEmployees;
	}
	
	public WebElement validateDashboardEmployees()
	{
		return DashboardEmployees;
	}
	
	public WebElement validateDropdownShowEmployees()
	{
		return DropdownshowEmployees;
	}

}
