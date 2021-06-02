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

public class TC_03TestLeadByWebsite extends BaseClass{

	
		@Test (groups = "regressionTest")
		public void SearchLeadByWebsite() throws Throwable {
		String website = eLib.getExcelData("po", 1, 5);
		
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.name("search_text")).sendKeys(website);
		
		wLib.waitforPageToLoad(driver);
		
		WebElement ele = driver.findElement(By.id("bas_searchfield"));
		
	wLib.select(ele, 5);
	driver.findElement(By.name("submit")).click();
		
	
	
		
	}

}
