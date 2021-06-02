package com.crm.comcast.purchaseordertest;

import java.util.Iterator;
/**
 * asha
 */
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;

public class CreatePurchaseOrderTest1 {

	private static TimeUnit timeunit;
	private static Object seconds;

	public static void main(String[] args) throws Throwable {

		
		//read the common data 
		PropertyFileUtility fil=new PropertyFileUtility();
		String USERNAME = fil.readDataFromPropertyFfile("username");
		String PASSWORD = fil.readDataFromPropertyFfile("password");
		String URL = fil.readDataFromPropertyFfile("url");
	
		//read the test data from excel file
		ExcelUtility efil=new ExcelUtility();
		String SUBJECT = efil.getExcelData("po", 1, 2);
		String VendorName = efil.getExcelData("po", 1, 3);
		String SearchValue= efil.getExcelData("po", 1, 4);
		String BillingAddress = efil.getExcelData("po", 1, 5);
		String ShippingAddress = efil.getExcelData("po", 1, 6);
		String ProductName= efil.getExcelData("po", 1, 7);
		String qty = efil.getExcelData("po", 1, 8);
		
		/*step 1 : login to app*/
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
		  
		  Object MovetoElement;
		//navigate to purchase order page
		  
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='More']"))).perform();
		driver.findElement(By.name("Purchase Order")).click();
		
		driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//navigate to create purchase orderpage
		
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys(SUBJECT);
		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img")).click();
		
		//switch to childbrowser
		String parentwindowid = driver.getWindowHandle();
		Set<String> set= driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
		 String currentwindow = null;
		for (int i = 0; i<set.size(); i++)
		{
			 currentwindow = it.next();
		driver.switchTo().window(currentwindow);
		String actualwindow = driver.getTitle();
		if (actualwindow.contains("Vendors")) {
			break;
		}
		
		 }
		driver.findElement(By.id("search_txt")).sendKeys(VendorName);
		WebElement ele = driver.findElement(By.name("search_field"));
		Select s=new Select(ele);
		s.selectByIndex(0);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("2")).click();
		
		Thread.sleep(3000);
		//WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"1\"]")));
		//switchback to parentwindow
		driver.switchTo().window(parentwindowid);
		
		driver.findElement(By.name("bill_street")).sendKeys(BillingAddress);
		driver.findElement(By.name("ship_street")).sendKeys(ShippingAddress);
		
		//select the product
		
		driver.findElement(By.id("searchIcon1")).click();
		
		//move to child winow in product page
		parentwindowid = driver.getWindowHandle();
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();

		for (int i = 0; i<set1.size(); i++) {
			String currectwindow = it1.next();
			driver.switchTo().window(currectwindow);
String actualwindow = driver.getTitle();
if(actualwindow.contains("Products"))
{
	break;
}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(ProductName);
		WebElement ele1 = driver.findElement(By.name("search_field"));
		Select s1= new Select(ele1);
		s1.selectByIndex(0);
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText(ProductName)).click();
		//move back to parentwindow
	
		driver.switchTo().window(parentwindowid);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		driver.findElement(By.id("qty1")).sendKeys(qty);
		driver.findElement(By.name("button")).click();
		
		Thread.sleep(5000);
		//verify the oputput
		String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		  if(actSuccessFullMsg.contains(SUBJECT)) {
			  System.out.println(SUBJECT + "==>purchase order created successfully==>PASS");
		  }else {
			  System.out.println(SUBJECT + "==>purchase order not created ==>Fail");
		
		
		
		
		
	}

}
}
