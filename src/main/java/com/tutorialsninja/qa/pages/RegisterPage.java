package com.tutorialsninja.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	 WebDriver driver;
	public RegisterPage(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	}
	
	//Objects
	
	//FirstName text field 
	@FindBy(id = "input-firstname")
	private WebElement registerfirstNameTextField;
	
	//Last Name text field  
	@FindBy(id="input-lastname")
	private WebElement registerLastNameTextField;
	
	//Email text field  input-confirm
	@FindBy(id="input-email")
	private WebElement registerEmailTextField;
	
	//Telephone text field  
	@FindBy(id="input-telephone")
	private WebElement registerTelephoneTextField;
	
	//Password text field  
	@FindBy(id="input-password")
	private WebElement registerpasswordTextField;
	
	//Confirm Password text field  
	@FindBy(id="input-confirm")
	private WebElement registerconfirmPasswordTextField;
	
	//Check box text field
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement registercheckBoxFiled;
	
	//Continue CTA 
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement registerContinueCTA;
	
	//Actions
	
	//Method for entering first Name 
	public void clickOnFirstNameTextFiled(String fName) {
		registerfirstNameTextField.sendKeys(fName);
		registerfirstNameTextField.sendKeys(Keys.TAB);
	}
	
	//Method for entering LastName text field
	public void clickOnLastNameTextField(String lName) {
		registerLastNameTextField.sendKeys(lName);
		registerLastNameTextField.sendKeys(Keys.TAB);
	}
	
	//Method for entering the mail id
	public void clickOnEmailTextField(String eMail) {
		registerEmailTextField.sendKeys(eMail);
		registerEmailTextField.sendKeys(Keys.TAB);
	}
	
	//method for entering the Mobile number
	public void clickAndEntreTelephoneNumber(String mobNumber) {
		registerTelephoneTextField.sendKeys(mobNumber);
		registerTelephoneTextField.sendKeys(Keys.TAB);
	}
	
	//method for entering Password and confirm password
	public void clickAndEnteringPasswordAndConfirmPassword(String pwd, String confirmPwd) {
		registerpasswordTextField.sendKeys(pwd);
		registerpasswordTextField.sendKeys(Keys.TAB);
		registerconfirmPasswordTextField.sendKeys(confirmPwd);
		registerconfirmPasswordTextField.sendKeys(Keys.TAB);
		registerconfirmPasswordTextField.sendKeys(Keys.TAB);
	}
	
	//method for clicking on the privacy&Policy check box
	public void clickOnPrivacyPolicyCheckBox() {
		registercheckBoxFiled.click();
	}
	
	//Method for clicking on the ContinueCTA
	public SuccessPage clickingOnContinueCTA() {
		registerContinueCTA.click();
		return new SuccessPage(driver);
	}
}
