package com.cpcTechnoSolutions.qa.testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cpcTechnoSolutions.qa.base.TestBase;
import com.cpcTechnoSolutions.qa.pages.ClientsPage;
import com.cpcTechnoSolutions.qa.pages.EmployeesPage;
import com.cpcTechnoSolutions.qa.pages.HomePage;
import com.cpcTechnoSolutions.qa.pages.LoginPage;
import com.cpcTechnoSolutions.qa.pages.ProjectsPage;

public class EmployeesPageTest extends TestBase {
	LoginPage loginpage;// to take the objects from the login
	HomePage homepage;
	EmployeesPage employeepage;
	ClientsPage clientspage;
	ProjectsPage projectspage;

	public EmployeesPageTest() {
		super();// we are calling ther super constructor from the testbase
	}

	/*
	 * Test case should be separated --independent to each other Before each test
	 * case --launch the Browser and login
	 * 
	 * @test--execute test case After each test case --close the Browser
	 */
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		employeepage = new EmployeesPage();
		clientspage = new ClientsPage();
		projectspage = new ProjectsPage();
		homepage = loginpage.validateLoginPage(prop.getProperty("Username"), prop.getProperty("Password"));

		employeepage = homepage.employeesViewMore();// it will click on employeesviewmore
	}

	@Test(priority = 1)
	public void validateEmployeePageTitleTest() {

		String Employeepagetitle = employeepage.validateEmployeesPageTitle();
		System.out.println("title of the page" + Employeepagetitle);
		Assert.assertEquals(Employeepagetitle, "Admin | Listofemployees");
	}

	@Test(priority = 2)
	public void validateListOfEmployeeTest() {

		String text = employeepage.validateListOfEmployeeText();
		System.out.println("Text" + text);

		boolean flag = employeepage.validateListOfEmployee();

		assertTrue(flag);
	}

	@Test(priority = 3)
	public void validateEmployeeSearchTest() {

		WebElement search = employeepage.validateSearchEmployees();
		search.sendKeys("smiley");
	}

	@Test(priority = 4)
	public void validateEmployeeDropdown() {

		WebElement showdropdown = employeepage.validateDropdownShowEmployees();
		Select selectdrpdown = new Select(showdropdown);
		selectdrpdown.selectByVisibleText("25");
		System.out.println("25 is selected");
	}

	@Test(priority = 5)
	public void validateEmployeeDashboard() {
		WebElement dashboard = employeepage.validateDashboardEmployees();
		dashboard.click();
		driver.getTitle();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
