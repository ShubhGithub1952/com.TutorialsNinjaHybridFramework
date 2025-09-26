package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
   //Locator for the CheckOut CTA
	@FindBy(linkText = "Checkout")
	private WebElement checkoutLinkCTA;
	
	//Actions
	//Click on the CheckOut CTA
	public CheckOutPage clickOnCheckOutCTA() {
		checkoutLinkCTA.click();
		return new CheckOutPage(driver);
	}
}
