package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.CheckOutPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.ProductDescriptionPage;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.qa.pages.ShoppingCartPage;

public class SearchTest extends Base {
	public WebDriver driver=null;
	HomePage homePage=null;
	SearchPage searchPage=null;
	ProductDescriptionPage productDesriptionPage=null;
	ShoppingCartPage shoppingCartPage=null;
	CheckOutPage checkOutPage=null;
	
	
	@Test(priority = 1)
	public void checkoutProcessWithoutLogin() {
		//Launch the Chrome browser 
		//!!Please_initialize_openbrowserApplication_with_driver_Object!!
		driver=openBrowserAndApplicationURL("firefox");
		//Create the Object of homepage
		 homePage = new HomePage(driver);
		
		//Create Object of search Page because it will landed on search Page after product searched
		searchPage = homePage.searchProduct("HP");
		
		//User Landed on the search Page now verify product displayed 
		String actualProduct="HP LP3065";
		Assert.assertEquals(actualProduct, searchPage.expectedProduct());
		
		//Click on the Product
		productDesriptionPage = searchPage.clickOnProdoct();
		
		//Verify the searched product display on Product description page
		Assert.assertEquals(productDesriptionPage.expectedProductTitle(), actualProduct);
		
		//Add product to cart
		productDesriptionPage.clickOnAddToCartCTA();
		
		//Verify success Message for Product added
		String expectedSuccessMessage=productDesriptionPage.printSuccessMessage();
		//System.out.println(productDesriptionPage.printSuccessMessage());
		
		//Verify the  expected with actual
		if(expectedSuccessMessage.contains("Success: You have added")){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		//Click on the shooping cart link text
		shoppingCartPage = productDesriptionPage.clickOnshoppingCart();
		
		//Click on CheckOut link CTA
		checkOutPage = shoppingCartPage.clickOnCheckOutCTA();
		
		String actualNewCustomerText = checkOutPage.getNewCustomerText();
		String expectedNewCustomerText="New Customer";
		
		//Verification if User is not logged in by verifying New Customer text
		Assert.assertEquals(actualNewCustomerText, expectedNewCustomerText);
		
		String actualRegisterCustomerText = checkOutPage.getRegisterCustomer();
		String expectedRegisterCustomerText="Returning Customer";
		
		//Verification if User is not logged in by verifying Register Customer text
		Assert.assertEquals(actualRegisterCustomerText, expectedRegisterCustomerText);
	}
	
	@Test(priority = 2)
	public void checkOutProcessWithLogin() {
		//Launch the Browser
		//Initialize the browser with driver reference
		driver=openBrowserAndApplicationURL("firefox");
		
		//To access HomePage webelement need to create the Object of homePage
		 homePage =new HomePage(driver);
		
		//Click on My account dropdown Menu
		homePage.clickOnMyAccountDropMenu();
		
		//Click on the Login Option
		LoginPage LoginPage = homePage.clickOnLoginOption();
		
		//Pass the valid userName and Password
		AccountPage accountPage = LoginPage.loginToApplication(getValidUserName(), getValidPassword());
		
		//Verify Whether the User landed on the account page
		Assert.assertTrue(accountPage.verifyEditYourAccountInformationelementDisplayed());
		
		//In the Search text field Search HP 
		searchPage=accountPage.searchItemTextField("HP");
		
		//Click on HP Product
		productDesriptionPage = searchPage.clickOnProdoct();
		
		//click on Add to Cart CTA
		productDesriptionPage.clickOnAddToCartCTA();
		
		//Verify whether product has added to cart or not
		Assert.assertTrue(productDesriptionPage.displayshoppingCartLinkText(), "Product has been added to CART");
		
		//Click on the shopping cart link Text
		shoppingCartPage=productDesriptionPage.clickOnshoppingCart();
		
		//Click on Checkout CTA
		checkOutPage=shoppingCartPage.clickOnCheckOutCTA();
		
		String actualBillingAddressText = checkOutPage.billingAddressDisplay();
		String expectedBillingAddressText="Step 2: Billing Details";
		
		//Verify the `Billing address displayes
		Assert.assertEquals(actualBillingAddressText, expectedBillingAddressText);
		
	}
	
	//Closing the browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}