package practice;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class screenshot extends BaseClass{

	/*
	 * public static void main(String[] args) throws Throwable { PropertyFileUtility
	 * file= new PropertyFileUtility(); String USERNAME =
	 * file.readDataFromPropertyFfile("username"); String PASSWORD =
	 * file.readDataFromPropertyFfile("password"); String BROWSER =
	 * file.readDataFromPropertyFfile("browser"); String URL =
	 * file.readDataFromPropertyFfile("url");
	 */
		
		
		//select the browser
		/*WebDriver driver = null;
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
		*/
	@Test
	
	public void CreateContact() throws Throwable {
		
		//create contact
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//fileuplaod
		wLib.scrollToWebElement(driver, driver.findElement(By.name("imagename")));
		
		driver.findElement(By.name("imagename")).sendKeys("C:\\Users\\Abiradar\\Downloads\\signature.jpg");
		wLib.pressEnterKey();
		
		//verify output
		
		
		
	//signout
	/*
	 * util.mouseOver(driver,
	 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	 * driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	 */
	
		
	}

}
