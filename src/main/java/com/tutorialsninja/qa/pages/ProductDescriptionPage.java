package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage {
   WebDriver driver;

	public ProductDescriptionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Objects
	//Xpath for product discription page
	@FindBy(xpath = "//div[@id='content']//h1")
	private WebElement productName;
	
	//Locator for the Add To Cart
	@FindBy(id = "button-cart")
	private WebElement addToCartCTA;
	
	//Locator for the Success message
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement addedToCartsuccessMesage;
	
	//Locator for the Shopping cart link text
	@FindBy (xpath = "//a[text()='shopping cart']")
	private WebElement shoppingCartCTA;
	
	//Actions
	
	//Method for the expected Product title
	public String expectedProductTitle() {
		return productName.getText();
	}
	
	//Method for the performing action on Add to Cart CTA
	public void clickOnAddToCartCTA() {
		addToCartCTA.click();
	}
	
	//Method for the Print the Printing success Message
	public String printSuccessMessage() {
		return addedToCartsuccessMesage.getText();
	}
	
	//Method for the Shopping cart link text
	public ShoppingCartPage clickOnshoppingCart() {
		shoppingCartCTA.click();
		return new ShoppingCartPage(driver);
	}
	
	//Verify shoppingCart link text displayed
	public boolean displayshoppingCartLinkText() {
		return shoppingCartCTA.isDisplayed();
	}
}
