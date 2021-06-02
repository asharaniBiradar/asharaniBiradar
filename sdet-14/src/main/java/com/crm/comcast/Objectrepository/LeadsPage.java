package com.crm.comcast.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class LeadsPage extends WebDriverUtility{
	WebDriver driver;

	public LeadsPage(WebDriver driver) {
		
	this.driver= driver;
PageFactory.initElements(driver, this);
	}
	
	
@FindBy(xpath="//img[@alt='Create Lead...']")
private WebElement createleadimg;

@FindBy(name="submit")
private  WebElement searchpage;

public WebElement getCreateleadimg() {
	return createleadimg;
}

public WebElement getSearchpage() {
	return searchpage;
}

public void createleadpage() {
	createleadimg.click();
}
}





	
	
	
