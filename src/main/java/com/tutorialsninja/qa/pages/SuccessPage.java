package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
	WebDriver driver;
	public SuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	
	//Your account created title
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement yourAccountCreatedTitle;
	
	//Continue CTA
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueCTA;
	
	//Actions
	
	//Method for the verify the title
	public boolean accountCreatedDisplay() {
		return yourAccountCreatedTitle.isDisplayed();
	}
	
	//Method for retriving Account created text
	public String accountCreatedText() {
		return yourAccountCreatedTitle.getText();
	}
	
	//Method for verifying Whether user Created and landing back to the Account page
	public AccountPage verifyAndPrintUserCreatedOrNot() {
		if (yourAccountCreatedTitle.getText().contains("Created")) {
			System.out.println(yourAccountCreatedTitle.getText());
		} else {
				System.out.println("User not created, Kindly provide the Valid credentials");
		}
		
		return new AccountPage(driver);
	}
}
