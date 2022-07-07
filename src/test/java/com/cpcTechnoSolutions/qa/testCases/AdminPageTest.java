package com.cpcTechnoSolutions.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cpcTechnoSolutions.qa.base.TestBase;
import com.cpcTechnoSolutions.qa.pages.AdminPage;
import com.cpcTechnoSolutions.qa.pages.ClientsPage;
import com.cpcTechnoSolutions.qa.pages.EmployeesPage;
import com.cpcTechnoSolutions.qa.pages.HomePage;
import com.cpcTechnoSolutions.qa.pages.LoginPage;
import com.cpcTechnoSolutions.qa.pages.ProjectsPage;

public class AdminPageTest extends TestBase {
	LoginPage loginpage;//to take the objects from the login 
	HomePage homepage;
	 EmployeesPage employeepage;
	 ClientsPage clientspage;
	 ProjectsPage projectspage;
	 AdminPage adminpage;
	public AdminPageTest()
	{
		super();//we are calling ther super constructor from the testbase
	}
	/*
	 * Test case should be separated --independent to each other
	 * Before each test case --launch the Browser and login
	 * @test--execute test case
	 * After each test case --close the Browser
	 */
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage=new LoginPage();
		employeepage=new EmployeesPage();
		clientspage=new ClientsPage();
		projectspage=new ProjectsPage();
		adminpage=new AdminPage();
		homepage=loginpage.validateLoginPage(prop.getProperty("Username"), prop.getProperty("Password"));
		adminpage.adminPageLink().click();
	}
	
	/*@Test(priority=0)
	public void adminpagelinkTest()
	{
		adminpage.adminPageLink().click();
	}*/
	
	
	@Test(priority=1,enabled=true)
	public void createEmployeeTest()
	{
		adminpage.createEmployee().click();
	}
	
	@Test(priority=2,enabled=true)
	public void CreateRolesTest()
	{
		adminpage.CreateRoles().click();
	}
	
	@Test(priority=3,enabled=true)
	public void DailyTransactionalDataTest()
	{
		adminpage.DailyTransactionalData().click();
	}
	
	@Test(priority=4,enabled=true)
	public void DocumentSetupTest()
	{
		adminpage.DocumentsSetup().click();
	}
	
	@Test(priority=5,enabled=true)
	public void EmailtoemployeesTest()
	{
		adminpage.Emailtoemployees().click();
	}
	
	@Test(priority=6,enabled=true)
	public void BeneficiaryTest()
	{
		adminpage.Beneficiary().click();
	}
	
	@Test(priority=7,enabled=true)
	public void JobDetailsTest()
	{
		adminpage.JobDetails().click();
	}
	
	@Test(priority=8,enabled=true)
	public void PaystubTest()
	{
		adminpage.Paystub().click();
	}
	
	@Test(priority=9,enabled=true)
	public void ProfilesTest()
	{
		adminpage.Profiles().click();
	}
	
	@Test(priority=10,enabled=true)
	public void  RateCalculatorsTest()
	{
		adminpage.RateCalculators().click();
	}
	
	
	@Test(priority=11,enabled=true)
	public void UploadTest()
	{
		adminpage.Upload().click();
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
