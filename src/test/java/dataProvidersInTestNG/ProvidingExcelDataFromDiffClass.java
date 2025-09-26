package dataProvidersInTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ProvidingExcelDataFromDiffClass {
	@DataProvider(name="dataSupplier")
	public Object [][] passingDataFromExcel() {
		String subPath = System.getProperty("user.dir");
		File filePath = new File(subPath+"\\src\\test\\resources\\TutorialsNinjaCred.xlsx");
		FileInputStream fis=null;
		try {
			fis= new FileInputStream(filePath);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook workbook =null;
		try {
		       workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet("dataProvider");
		
		int rcount = sheet.getPhysicalNumberOfRows();
		int cCount = sheet.getRow(0).getLastCellNum();
		Object [][]data= new Object[rcount-1][cCount];
		
		for (int i = 0; i < rcount-1; i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for (int j = 0; j < cCount; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					data[i][j]=cell.getStringCellValue();
					System.out.println(data[i][j]);
					break;
				case NUMERIC:
					data[i][j]=cell.getNumericCellValue();
					System.out.println(data[i][j]);
					break;
				case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					System.out.println(data[i][j]);
					break;
				}
			}
		}
		return data;
	}

}
