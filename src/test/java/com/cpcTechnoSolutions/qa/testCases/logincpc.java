package com.cpcTechnoSolutions.qa.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cpcTechnoSolutions.qa.utils.TestUtils;
import com.cpcTechnoSolutions.qa.utils.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logincpc {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("http://cpcats.cpctechno.com/admin/index");
		
	}
	
	@Test(dataProvider="LoginData")
	public void loginTestData(String username,String password,String expected) throws InterruptedException
	{
		//System.out.println(username+password+expected);
		
		
		WebElement user=driver.findElement(By.xpath("//input[@id='login-username']"));
		user.clear();
		user.sendKeys(username);
		
		WebElement pwd=driver.findElement(By.xpath("//input[@id='login-password']"));
		pwd.clear();
		pwd.sendKeys(password);
		
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		String exp_tittle="Dashboard";
		String act_tittle=driver.getTitle();
		System.out.println(act_tittle);
		Actions act=new Actions(driver);
		WebElement cpcdropdownlogo = driver.findElement(By.xpath("//img[@class='img-responsive']"));
		Thread.sleep(2000);
		act.moveToElement(cpcdropdownlogo).build().perform();
		
		
		if(expected.equals("Valid"))
		{
			if(exp_tittle.equals(act_tittle))
			{
				Assert.assertTrue(true);
				driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/ul[1]/li[1]/ul[1]/li[3]/a[1]")).click();
				
			}else
			{
				Assert.assertTrue(false);
			}
			
		}
		//if the login test is not succesfully login then it is considered as pass
		else if(expected.equals("InValid"))
		{
			if(exp_tittle.equals(act_tittle))
			{
				Assert.assertTrue(false);
				driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/ul[1]/li[1]/ul[1]/li[3]/a[1]")).click();
				
			}else
			{
				Assert.assertTrue(true);
			}
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String [][]getData() throws IOException
	{
		/*String loginData[][]= {
				{"cpctechnosolutions","Test@123","Valid"},
				{"cpctechnosolutions","Test@333","InValid"},
				{"cpctechnolutions","Test@123","InValid"},
				{"cpctechnosolutions","test@#123","InValid"}};*/
		
	Xls_Reader reader=new Xls_Reader("D:\\KaranSelenium\\framework\\src\\main\\java\\com\\cpcTechnoSolutions\\qa\\config\\CPCLoginData.xlsx");
	 int totalrows=reader.getRowCount("cpcData");
	int totalcol= reader.getCellCount("cpcData",1);
	
	String loginData[][]=new String[totalrows][totalcol];
	
	for (int i = 1; i <totalrows; i++) {
		for(int j=0;j<totalcol;j++)
		{
		loginData[i-1][j] =reader.getCellData("cpcData", i,j);
		}
		
	}
	
	
	return loginData ;
		
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}


}
