
package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utilPackage.GeneralUtility;

public class LoginTest extends Base {
	public WebDriver driver=null;
	
	@Test(dataProvider = "dataSupplier")
	public void loginWithValidCredentials(String uName, String pwd) {
		
		//Pass the Browser Name to launch application
		//!!Please_initialize_openbrowserApplication_with_driver_Object!!
		driver=openBrowserAndApplicationURL("firefox");
		
		//Create The Object of HOmepage to access method in it
		HomePage homePage = new HomePage(driver);
		
		//Click on My account drop menu
		homePage.clickOnMyAccountDropMenu();
		
		//Click on the Login Option
		LoginPage loginPage = homePage.clickOnLoginOption();
		
		//Now It will landed on the Login Page and pass the application credentials
		AccountPage accountPage = loginPage.loginToApplication(uName, pwd);
		
		//Verify if user successfully logged in the app Should get landed on the Account page 
		//and Edit account information element should displayed
		Assert.assertTrue(accountPage.verifyEditYourAccountInformationelementDisplayed());
		
	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		Object [][]data=null;
		data=GeneralUtility.readLoginDataFromExcel("dataProvider");
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
