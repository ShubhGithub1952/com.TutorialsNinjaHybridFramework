package dependsOnMethodInTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WishListTest {
	WebDriver driver;
	@Test
	public void userLogin() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys("pixelMagic1952@gmail.com");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("Pixel@1952");
		password.sendKeys(Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@Test(dependsOnMethods = {"userLogin"})
	public void addProductToWishListAndViewTheWishList() {
		driver.findElement(By.name("search")).sendKeys("HP",Keys.ENTER);
		driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement wishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("wish list")));
		wishList.click();
		Assert.assertTrue(driver.getTitle().equals("My Wish List"));
	}
	
	@Test(dependsOnMethods = {"userLogin","addProductToWishListAndViewTheWishList"})
	public void removeProductFromWishlist() {
		driver.findElement(By.xpath("//a[@data-original-title='Remove']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/p")).getText().equals("Your wish list is empty."));
    }
}
