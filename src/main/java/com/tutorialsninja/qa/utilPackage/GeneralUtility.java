package com.tutorialsninja.qa.utilPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GeneralUtility {
	
	
	
	//To provide implicitly wait creating final static object
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_WAIT_TIME=5;
	
	//Create a random number
  	public static Integer generateRandomNumber() {
  		Random random = new Random();
  		return random.nextInt(100000);	
  	}
  	
  
	public static Object[][] readLoginDataFromExcel(String sheetName) {
		
		FileInputStream fis =null;
		XSSFWorkbook workbook=null;
		File file=null;
		//TO get the local system directory
		String path = System.getProperty("user.dir");
		
		//TO get file path of in the project
		file= new File(path+"//src//main//resources//testData//TutorialsNinjaCred.xlsx");
		
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rCount = sheet.getLastRowNum();
		int cCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object [][]data= new Object[rCount][cCount];
		
		for (int i = 0; i < rCount; i++) {
			
			XSSFRow row = sheet.getRow(i+1);
			
			for (int j = 0; j < cCount; j++) {
				XSSFCell cell = row.getCell(j);
				CellType CellValue = cell.getCellType();
				
				switch (CellValue) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j]=cell.getNumericCellValue();
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				}
				
			}
		}
		return data;
	}
	
	public static String captureScreenshotMethod(WebDriver driver, String testName) {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\src\\main\\resources\\screenshots\\"+testName+".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(srcFile, new File(destFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destFile;
	}
}
