package com.crm.comcast.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadpage {
	WebDriver driver;

	public CreateNewLeadpage(WebDriver driver) {
		
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameEdit;
	
	@FindBy(name="company")
	private WebElement companyEdit;
	
	@FindBy(name="button")
	private WebElement buttonEdit;

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getCompanyEdit() {
		return companyEdit;
	}

	public WebElement getButtonEdit() {
		return buttonEdit;
	}

	public void createLeads(String lastname,String COMPANY) {
		lastnameEdit.sendKeys(lastname);
		companyEdit.sendKeys(COMPANY);
		buttonEdit.click();
	
	}
}
