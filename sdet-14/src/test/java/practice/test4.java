package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;

public class test4 extends BaseClass{
	
	@Test
	
	
	public void autosuggestion() throws InterruptedException {
		
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys("seleni");
		Thread.sleep(3000);
		List<WebElement> ele1 = driver.findElements(By.xpath("//li[@class='sbct']"));
		System.out.println(ele1.size());

		for(WebElement b:ele1) {
			System.out.println(b.getText());
		}
		driver.close();

		
	
	
	
	 
	}
}