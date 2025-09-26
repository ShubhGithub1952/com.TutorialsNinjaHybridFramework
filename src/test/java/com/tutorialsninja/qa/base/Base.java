package com.tutorialsninja.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.tutorialsninja.qa.utilPackage.GeneralUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public Properties prop;
	File dataPath=null;
	FileInputStream fis=null;
	WebDriver driver;
	
	//Launch the browser by passing Browser Name
  public WebDriver openBrowserAndApplicationURL(String browser) {
	   prop = new Properties();
	   dataPath = new File("src//main//resources//testData//data.properties");
	  try {
		fis = new FileInputStream(dataPath);
		prop.load(fis);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	  if (browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	} else if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	} 
	else if (browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtility.IMPLICIT_WAIT_TIME));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GeneralUtility.PAGE_WAIT_TIME));
	  driver.get(prop.getProperty("url"));
	  return driver;
  }
  
	//To get Valid user Name from Properties file
		  public String getValidUserName() {
			  try {
				prop.load(fis);
			  } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			  
			  return prop.getProperty("login");
		  }
  
  // To Get Valid Password from Properties file
	  public String getValidPassword() {
		  try {
			prop.load(fis);
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  
		  return prop.getProperty("password");
	  }
  
}
