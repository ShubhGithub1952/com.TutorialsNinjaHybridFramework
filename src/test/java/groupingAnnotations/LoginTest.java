package groupingAnnotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends Base {
	
WebDriver driver=null;;
	

	@Test(priority = 1, retryAnalyzer = com.tutorialsninja.qa.listeners.RetryAnalyzer.class)
	public void loginWithValidCredentials() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
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
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account informationabc")).isDisplayed());
	}
	
	@Test(priority = 2, dependsOnMethods = "loginWithValidCredentials")
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
		system.out.println("Webdriver browser should get closed post the execution of every TC !!");
		System.out.println("After Method !!");
		driver.quit();
	}

}
