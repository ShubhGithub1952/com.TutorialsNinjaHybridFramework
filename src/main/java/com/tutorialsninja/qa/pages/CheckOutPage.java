package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	WebDriver driver;

	//Add Constructor
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	//Locator for New Customer Text
	@FindBy(xpath = "(//div[@class='panel-collapse collapse in']//h2)[1]")
	private WebElement newCustomerText;
	
	//Locator for Returning customer
	@FindBy(xpath = "(//div[@class='panel-collapse collapse in']//h2)[2]")
	private WebElement returningCustomerText;
	
	//Locator for the Billing address Text
	@FindBy(xpath = "//a[text()='Step 2: Billing Details ']")
	private WebElement billingaddressText;
	
	//Actions
	//Method for New Customer text
	public String getNewCustomerText() {
		return newCustomerText.getText();
	}
	
	//Method for Register Customer text
	public String getRegisterCustomer() {
		return returningCustomerText.getText();
	}
	
	//Method for the Billing address displayed
	public String billingAddressDisplay() {
		return billingaddressText.getText();
	}

}
