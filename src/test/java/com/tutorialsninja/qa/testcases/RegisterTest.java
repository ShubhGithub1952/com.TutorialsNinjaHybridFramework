package com.tutorialsninja.qa.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.pages.SuccessPage;
import com.tutorialsninja.qa.utilPackage.GeneralUtility;

public class RegisterTest extends Base {
	public WebDriver driver=null;
	
	@Test(dataProvider = "dataSupplier")
  public void registerToTutorialsNinja(String fName, String lName) throws MalformedURLException  {
		
	//!!Please_initialize_openbrowserApplication_with_driver_Object!!
	  driver=openBrowserAndApplicationURL("firefox");
	  HomePage homePage = new HomePage(driver);
	  
	  //Click on My account drop menu
	  homePage.clickOnMyAccountDropMenu();
	  
	  //Click on the Register Option for new user
	  RegisterPage register=homePage.clickOnRegisterOption();
	  
	  //Enter the FirstName text field
	  register.clickOnFirstNameTextFiled(fName);
	  
	  //Enter the lName text
	  register.clickOnLastNameTextField(lName);
	  
	  //need to take random number for executing Methods
	  Integer random = GeneralUtility.generateRandomNumber();
	  
	  //Enter the Email in text field
	  register.clickOnEmailTextField(fName+random+"@gmail.com");
	  //System.out.println(fName+random+"@gmail.com");
	  
	  //Enter the Telephone number
	  register.clickAndEntreTelephoneNumber("8411"+random);
	 // System.out.println("8411"+random);
	  
	  //Enter Password
	  register.clickAndEnteringPasswordAndConfirmPassword(random.toString() , random.toString());
	  //System.out.println(random.toString());
	  
	  //Click on the Check box
	  register.clickOnPrivacyPolicyCheckBox();
	  
	  //Click on the continue CTA
	  SuccessPage successPage = register.clickingOnContinueCTA();
	  
	  //Using assertion verify user created or not
	  String actualText = successPage.accountCreatedText();
	 String  expectedText="Your Account Has Been Created!";
	 
	 Assert.assertEquals(actualText, expectedText);
	  //verify Whether user created or not
	  successPage.verifyAndPrintUserCreatedOrNot();
  }
	
	//Using DataProvider passing the data
	@DataProvider(name="dataSupplier")
	public Object[][] dataSupplier() {
		Object[][]data=null;
		//Need to pass the sheet name to run this TC by creating MyXlsReader Object
		data=GeneralUtility.readLoginDataFromExcel("registerCred");
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
