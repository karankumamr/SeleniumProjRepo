package com.cpcTechnoSolutions.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpcTechnoSolutions.qa.base.TestBase;
import com.cpcTechnoSolutions.qa.pages.AdminPage;
import com.cpcTechnoSolutions.qa.pages.ClientsPage;
import com.cpcTechnoSolutions.qa.pages.EmployeesPage;
import com.cpcTechnoSolutions.qa.pages.HomePage;
import com.cpcTechnoSolutions.qa.pages.LoginPage;
import com.cpcTechnoSolutions.qa.pages.ProjectsPage;
import com.cpcTechnoSolutions.qa.utils.TestUtils;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;//to take the objects from the login 
	HomePage homepage;
	 EmployeesPage employeepage;
	 ClientsPage clientspage;
	 ProjectsPage projectspage;
	 AdminPage adminpage;
	public HomePageTest()
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
	
		
	
	}
	
	@Test(priority=1,enabled=true)
	public void validateHomePageTitleTest()
	{
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Dashboard","Home page title not matched");
	}
	
	@Test(priority=2,enabled=true)
	public void validateDashboardNameTest()
	{
		boolean flag=homepage.verifyCorrectDashboardText();
		Assert.assertTrue(flag);
	}
	@Test(priority=3,enabled=true)
	public void ValidateChangePassword()
	{
		homepage.clickOnChangePassword().click();
		homepage.closeChangePassword().click();
	}
	@Test(priority=4,enabled=true)
	public void ValidateEmployeesLinkTest()
	{
		employeepage=homepage.employeesViewMore();
	}
	
	@Test(priority=5,enabled=true)
	public void validateClientsLinkTest()
	{
		clientspage=homepage.clientsViewMore();
	}
	@Test(priority=6,enabled=true)
	public void validateProjectsLinkTest()
	{
		projectspage=homepage.projectsViewMore();
	}
	
	@Test(priority=7)
	public void clickOnAdmin()
	{
		adminpage=homepage.Admin();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
