package com.crm.comcast.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class leadinfopage extends WebDriverUtility{
	WebDriver driver;
public leadinfopage(WebDriver driver) {
		
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualmsg;
	
	public WebElement successfulmsg() {
		return actualmsg;
	}
}
