package ddFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	@Test(dataProvider = "supplier")
	public void loginToWebPage(String uName, String pwd) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("input-email")).sendKeys(uName);
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys(pwd);
		password.sendKeys(Keys.ENTER);
		WebElement editOption = driver.findElement(By.xpath("//a[text()='Edit your account information']"));
		System.out.println( editOption.getText());
		Assert.assertTrue(editOption.isDisplayed());
		
	}
	@DataProvider(name="supplier")
	public Object[][] dataSupplier() {
		Object [][]data= {{"pixelMagic1952@gmail.com","Pixel@1952"},
						{"pixelMagic1953@gmail.com","Pixel@1953"},
						{"pixelMagic1954@gmail.com","Pixel@1954"}};
		return data;
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
