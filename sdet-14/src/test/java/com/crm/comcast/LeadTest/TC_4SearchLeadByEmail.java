package com.crm.comcast.LeadTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_4SearchLeadByEmail {

	public static void main(String[] args) throws Throwable {
		//read the common data
		
				PropertyFileUtility file= new PropertyFileUtility();
				String USERNAME = file.readDataFromPropertyFfile("username");
				String PASSWORD = file.readDataFromPropertyFfile("password");
				String BROWSER = file.readDataFromPropertyFfile("browser");
				String URL = file.readDataFromPropertyFfile("url");
				
				//read the data from excel
				
				ExcelUtility efil= new ExcelUtility();
				
				String email = efil.getExcelData("po", 1, 6);
				
				
				//select the browser
				WebDriver driver = null;
				if(BROWSER.equalsIgnoreCase("chrome")){
					 driver=new ChromeDriver();
					
				}else if(BROWSER.equalsIgnoreCase("firefox")) {
					 driver=new ChromeDriver();
				}
				
				driver.manage().window().maximize();
				driver.get(URL);
				
				//webdriver Utility
				WebDriverUtility util= new WebDriverUtility();
				
				//login to application
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.name("search_text")).sendKeys(email);
				util.waitforPageToLoad(driver);
				
				WebElement ele = driver.findElement(By.id("bas_searchfield"));
			util.select(ele, "Email");
			driver.findElement(By.name("submit")).click();
				
			//signout
			util.mouseOver(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
	}

	}


