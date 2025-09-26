package com.tutorialsninja.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
 WebDriver driver;
 
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	//locator of email text field
	@FindBy(id = "input-email")
	private WebElement emailAddressTextField;
	
	//Locator for the password text field
	@FindBy(id = "input-password")
	private WebElement passwordTextfiled;
	
	//Actions
	public AccountPage loginToApplication(String Uname, String pwd) {
		emailAddressTextField.clear();
		emailAddressTextField.sendKeys(Uname);
		passwordTextfiled.clear();
		passwordTextfiled.sendKeys(pwd);
		passwordTextfiled.sendKeys(Keys.ENTER);
		
		return new AccountPage(driver);
	}
}
