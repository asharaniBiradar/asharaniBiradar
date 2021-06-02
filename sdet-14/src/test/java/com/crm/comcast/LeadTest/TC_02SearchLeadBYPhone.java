package com.crm.comcast.LeadTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_02SearchLeadBYPhone extends BaseClass{

	@Test (groups = "smokeTest")
	
	public void leadByPhone() throws Throwable {
		
		ExcelUtility eutil= new ExcelUtility();
		
				String phoneno = eutil.getExcelData("po", 1, 4);
				
				//search contact by phone
				
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.name("search_text")).sendKeys(phoneno);
				wLib.waitforPageToLoad(driver);
				
			
				wLib.select(driver.findElement(By.id("bas_searchfield")), 4);
			
			driver.findElement(By.name("submit")).click();
				
			
			
	}

	
	
}
