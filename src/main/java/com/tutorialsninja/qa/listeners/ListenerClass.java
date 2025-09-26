package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilPackage.GeneralUtility;
import com.tutorialsninja.qa.utilPackage.MyExtendReport;

public class ListenerClass implements ITestListener {
	
	String testName=null;
	
	ExtentReports extentReport = MyExtendReport.getExtentReport();
	ExtentTest extentTest;
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getMethod().getMethodName());
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test has Passed !!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testName = result.getMethod().getMethodName();
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException |IllegalAccessException |NoSuchFieldException |SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String destScreenshotPath = GeneralUtility.captureScreenshotMethod(driver, result.getMethod().getMethodName());
		
		extentTest.addScreenCaptureFromPath(destScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
	    extentTest.log(Status.FAIL, "Test has Failed !!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testName = result.getMethod().getMethodName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,testName +" got Skipped !");
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String sourcePath = System.getProperty("user.dir")+"\\test-output\\reports\\extentreport.html";
		File extentReportPath= new File(sourcePath);
		try {
			Desktop.getDesktop().browse(extentReportPath.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
