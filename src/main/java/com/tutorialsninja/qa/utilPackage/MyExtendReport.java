package com.tutorialsninja.qa.utilPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyExtendReport {

		public static ExtentReports getExtentReport() {
			String extenteportFilePath= System.getProperty("user.dir")+"\\test-output\\reports\\extentreport.html";
			ExtentSparkReporter sparkReport = new ExtentSparkReporter(extenteportFilePath);
			sparkReport.config().setReportName("TutorialsNinja Automation Result");
			sparkReport.config().setDocumentTitle("TutorialsNinja Test Automation Result");
			
			//Create the object of Extent Report
			ExtentReports extentReport = new ExtentReports();
			extentReport.attachReporter(sparkReport);
			extentReport.setSystemInfo("Selenium Version", "4.34.0");
			extentReport.setSystemInfo("Operating System", "Windows 11");
			extentReport.setSystemInfo("Executed By", "Shubham P");
			return extentReport;
			
	}
}
