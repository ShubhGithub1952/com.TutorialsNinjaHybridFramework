package annotationsInTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTestCaseByAnnotations {
WebDriver driver;
	
	@BeforeSuite
	public void beforeSuit() {
	System.out.println("Before Suit !!");
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("After Suit !!");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test !!");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test !!");
	}
	
	@BeforeMethod
	public void startup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		System.out.println("Before Method !!");
	}
	@Test(priority = 1)
	public void loginWithValidCredentials() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("pixelMagic1952@gmail.com");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("Pixel@1952");
		password.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void loginWithInvalidEmailAndValidPassword() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("pixelMagic1925@gmail.com");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("Pixel@1952");
		password.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(text);
		
	}
	@Test(priority = 3)
	public void loginWithValidUserNameInvalidPassword() throws Exception {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("pixelMagic1952@gmail.com");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("Pixel1952");
		password.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(text);
	}
	
	@Test(priority = 4)
	public void loginWithInvalidUserNameInvalidPassword() throws Exception {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("pixelMagic1924@gmail.com");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("Pixel1952");
		password.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		System.out.println(text);
	}
	@AfterMethod
	public void closer() {
		System.out.println("After Method !!");
		driver.quit();
	}

}
