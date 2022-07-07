package com.cpcTechnoSolutions.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cpcTechnoSolutions.qa.base.TestBase;

public class AdminPage extends TestBase{
	
	@FindBy(xpath="//a/span[contains(text(),'Admin')]")
	WebElement Adminpagelink;
	
	@FindBy(xpath="//a[contains(text(),'Create Employee ')]")
	WebElement CreateEmployeelink;
	
	@FindBy(xpath="//a[contains(text(),'Creating Roles')]")
	WebElement CreateRoleslink;
	
	@FindBy(xpath="//a[contains(text(),'Daily Transactional Data ')]")
	WebElement DailyTransactionalDatalink;
	
	@FindBy(xpath="//a[contains(text(),'Documents Setup ')]")
	WebElement DocumentsSetuplink ;
	
	@FindBy(xpath="//li[5]/a[contains(text(),'Email to employees')]")
	WebElement Emailtoemployeeslink;
	
	@FindBy(xpath="//li[6]/a[contains(text(),'Beneficiary')]")
	WebElement BeneficiaryLink;
	
	@FindBy(xpath="//li[7]/a[contains(text(),'Job Details')]")
	WebElement JobDetailslink;
	
	@FindBy(xpath="//li[8]/a[contains(text(),'Paystub')]")
	WebElement Paystublink;
	
	@FindBy(xpath="//li[9]/a[contains(text(),'Profiles/Resumes')]")
	WebElement Profileslink;
	
	@FindBy(xpath="//li[10]/a[contains(text(),'Projects')]")
	WebElement Projectslink;
	
	@FindBy(xpath="//li[11]/a[contains(text(),'Rate Calculators ')]")
	WebElement RateCalculatorslink;
	
	@FindBy(xpath="//li[12]/a[contains(text(),'Upload PAF' )]")
	WebElement Uploadlink;
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement adminPageLink()
	{
		return Adminpagelink;
	}
	
	public WebElement createEmployee()
	{
		return CreateEmployeelink;
	}
	
	public WebElement CreateRoles()
	{
		return CreateRoleslink;
	}
	public WebElement DailyTransactionalData()
	{
		return DailyTransactionalDatalink;
	}
	public WebElement DocumentsSetup()
	{
		return DocumentsSetuplink;
	}
	public WebElement Emailtoemployees()
	{
		return Emailtoemployeeslink;
	}
	public WebElement Beneficiary()
	{
		return BeneficiaryLink;
	}
	public WebElement JobDetails()
	{
		return JobDetailslink;
	}
	public WebElement Paystub()
	{
		return Paystublink;
	}
	public WebElement Profiles()
	{
		return Profileslink;
	}
	public WebElement Projects()
	{
		return Projectslink;
	}
	public WebElement RateCalculators()
	{
		return RateCalculatorslink;
	}
	public WebElement Upload()
	{
		return Uploadlink;
	}
	

}
