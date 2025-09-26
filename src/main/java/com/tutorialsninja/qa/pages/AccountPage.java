package com.tutorialsninja.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	//Locator for the Edit your account information element
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformation;
	
	//Locator for Search element 
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement searchTextField;
	
	//Actions
	//Method to click on the EditYourAccountInformation
	public boolean verifyEditYourAccountInformationelementDisplayed() {
		boolean displayStatus=false;
		try {
			displayStatus= editYourAccountInformation.isDisplayed();
		} catch (Throwable e) {
			// TODO: handle exception
		}
		 return displayStatus;
	}
	
	public SearchPage searchItemTextField(String itemName) {
		searchTextField.clear();
		searchTextField.sendKeys(itemName);
		searchTextField.sendKeys(Keys.ENTER);
		return new SearchPage(driver);
	}
	
}
