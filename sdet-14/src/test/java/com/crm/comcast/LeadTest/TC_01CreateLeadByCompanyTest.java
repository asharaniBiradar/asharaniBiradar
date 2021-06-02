package com.crm.comcast.LeadTest;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.Objectrepository.CreateNewLeadpage;
import com.crm.comcast.Objectrepository.HomePage;
import com.crm.comcast.Objectrepository.LeadsPage;
import com.crm.comcast.Objectrepository.leadinfopage;
import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_01CreateLeadByCompanyTest extends BaseClass{


	@Test (groups = "smokeTest")
	public void CreateLead() throws Throwable
	{

		//read the common data
		/*
		 * PropertyFileUtility file= new PropertyFileUtility(); String USERNAME =
		 * file.readDataFromPropertyFfile("username"); String PASSWORD =
		 * file.readDataFromPropertyFfile("password"); String BROWSER =
		 * file.readDataFromPropertyFfile("browser"); String URL =
		 * file.readDataFromPropertyFfile("url");
		 */
		
		//read the data from excel
		
		ExcelUtility efil= new ExcelUtility();
		String COMPANY = efil.getExcelData("po", 1, 2);
		String lastname = efil.getExcelData("po", 1, 3);
		
		//select the browser
		/*
		 * WebDriver driver = null; if(BROWSER.equalsIgnoreCase("chrome")){ driver=new
		 * ChromeDriver();
		 * 
		 * }else if(BROWSER.equalsIgnoreCase("firefox")) { driver=new ChromeDriver(); }
		 * 
		 * driver.manage().window().maximize(); driver.get(URL);
		 */
		
		//login to application
		
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		
		//create the lead
		//driver.findElement(By.linkText("Leads")).click();
		HomePage hpage=new HomePage(driver);
		hpage.navigatetolead();
		
		//driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		LeadsPage lpage=new LeadsPage(driver);
		lpage.createleadpage();
		
		/*
		 * driver.findElement(By.name("lastname")).sendKeys(lastname);
		 * driver.findElement(By.name("company")).sendKeys(COMPANY);
		 * driver.findElement(By.name("button")).click();
		 */
		CreateNewLeadpage newlpage= new CreateNewLeadpage(driver);
		newlpage.createLeads(lastname, COMPANY);
		
		//verify the output
		
		leadinfopage lif= new leadinfopage(driver);
	String actualsuccessfulmsg= lif.successfulmsg().getText();	
	
	System.out.println(actualsuccessfulmsg);
Assert.assertFalse(actualsuccessfulmsg.contains(lastname));		
		/*
		 * String actualmsg =
		 * driver.findElement(By.id("mouseArea_Last Name")).getText();
		 * Assert.assertEquals(actualmsg, lastname, "test case failed");
		 */
	}
		
				
	/*
	 * @Test (groups = "regressionTest")
	 * 
	 * public void leadByPhone() throws Throwable {
	 * 
	 * ExcelUtility eutil= new ExcelUtility();
	 * 
	 * //String phoneno = eutil.getExcelData("po", 1, 4);
	 * 
	 * //search contact by phone
	 * 
	 * driver.findElement(By.linkText("Leads")).click();
	 * driver.findElement(By.name("search_text")).sendKeys("9880237959");
	 * wLib.waitforPageToLoad(driver);
	 * 
	 * 
	 * wLib.select(driver.findElement(By.id("bas_searchfield")), 4);
	 * 
	 * driver.findElement(By.name("submit")).click();
	 * 
	 * 
	 * 
	 * }
	 */
		
		
	}