package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	//Xpath of the My Account drop menu on the Homepage
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	//xpath of the Login option on homePage
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginOption;
	
	//xPath of the Register option
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerOption;
	
	//Xpath for finding search field
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchTextField;
	
	//Xpath for clicking on the search icon
	@FindBy(xpath = "//span[@class='input-group-btn']//i")
	private WebElement homePageSearchIcon;
	
	//Actions
	//Method to access the my Account 
	public void clickOnMyAccountDropMenu() {
		MyAccountDropMenu.click();
	}
	
	//Method to click on the Login button
	public LoginPage clickOnLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	//Method to click on the Register options
	public RegisterPage clickOnRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	//To enter text into the search field and click search item
	public SearchPage searchProduct(String productName) {
		searchTextField.sendKeys(productName);
		homePageSearchIcon.click();
		return new SearchPage(driver);
	}
}
