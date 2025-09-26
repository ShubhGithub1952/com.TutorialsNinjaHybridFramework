package dataProvidersInTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToTutorialsNinjaTest {
WebDriver driver;
	
	@Test(dataProvider = "getTestData",dataProviderClass=ProvideDataFromDiifClass.class)
	public void userLogin(String uName, String pwd) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys(uName);
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys(pwd);
		password.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}
	
//	@DataProvider
//	public String [][] dataSupplier() {
//		String [][]data= {{"pixelMagic1952@gmail.com","Pixel@1952"},
//				          {"pixelMagic1953@gmail.com","Pixel@1953"},
//				          {"pixelMagic1954@gmail.com","Pixel@1954"}};
//		return data;
//	}
}
