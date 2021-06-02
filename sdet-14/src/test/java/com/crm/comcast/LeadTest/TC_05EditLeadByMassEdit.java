package com.crm.comcast.LeadTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_05EditLeadByMassEdit {

	public static void main(String[] args) throws Throwable {
		//read the common data
		
				PropertyFileUtility file= new PropertyFileUtility();
				String USERNAME = file.readDataFromPropertyFfile("username");
				String PASSWORD = file.readDataFromPropertyFfile("password");
				String BROWSER = file.readDataFromPropertyFfile("browser");
				String URL = file.readDataFromPropertyFfile("url");
				
						
				
				//select the browser
				WebDriver driver = null;
				if(BROWSER.equalsIgnoreCase("chrome")){
					 driver=new ChromeDriver();
					
				}else if(BROWSER.equalsIgnoreCase("firefox")) {
					 driver=new ChromeDriver();
				}
				
				driver.manage().window().maximize();
				driver.get(URL);
				WebDriverUtility util= new WebDriverUtility();
				
				//login to application
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Leads")).click();
				
				//edit massedit
				driver.findElement(By.xpath("//input[@value='Mass Edit'][1]")).click();
				
			//signout
			util.mouseOver(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
