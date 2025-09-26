package assertionsInTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyScriptUsingAssertion1 {
	   //      @test
//		public void testTutorialNinja() {
//			WebDriverManager.chromedriver().setup();
//			WebDriver driver=new ChromeDriver();
//			driver.manage().window().maximize();
//			driver.get("https://tutorialsninja.com/demo/");
	//	
//		    String actualTitle = driver.getTitle();
//		    String expectedTitle="Your Store";
//		   Assert.assertEquals(actualTitle, expectedTitle);
//		   driver.quit();
//		}
		 
//		 public void verifyAsserTrue() {
//			 String str="My Name is Shubham !";
//			 Assert.assertTrue(str.contains("Shubham"));
//		 }
		 
//		 //isDisplayed() method testing
//		 public void testHPProduct() {
//					WebDriverManager.chromedriver().setup();
//					WebDriver driver=new ChromeDriver();
//					driver.manage().window().maximize();
//					driver.get("https://tutorialsninja.com/demo/");
//					driver.findElement(By.xpath("(//input[@name=\"search\"])[1]")).sendKeys("HP", Keys.ENTER);
//					Assert.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed());
//					driver.quit();
//		 }
		 
		
		//Using Soft assert verify the test case
		
		 @Test
		 public void softAssertTesting() {
			 WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://tutorialsninja.com/demo/");
				SoftAssert softAssert = new SoftAssert();
				
				String actualTitle = driver.getTitle();
			    //System.out.println(actualTitle);
				String expectedTitle="Your Store";
				softAssert.assertEquals(actualTitle, expectedTitle);
				driver.findElement(By.xpath("(//input[@name=\"search\"])[1]")).sendKeys("HP", Keys.ENTER);
	  			softAssert.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed());
				
				softAssert.assertAll();
				driver.quit();
		 }
}
