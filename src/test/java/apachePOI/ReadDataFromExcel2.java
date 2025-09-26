package apachePOI;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel2 {
	public static void main(String[] args) throws Exception {
		//Reading data from the college excel sheet
		//Create a variable to get the user directory path
		String path = System.getProperty("user.dir");
		path=path+"//src//test//resources//TutorialsNinjaCred.xlsx";
		File file = new File(path);
		
		//TO read data from apache commonio create a object of FileInputStream
		FileInputStream fis = new FileInputStream(file);
		
		//Now to read data from the Excel file then Create the object from the XSSFWorkbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//Create a object of sheet to fetch data
		XSSFSheet sheet = workbook.getSheet("temp1");
		
		int rowCount=sheet.getLastRowNum();
		System.out.println(rowCount);
		
		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			int cellCount = row.getLastCellNum();
			
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cellValue = row.getCell(j);
				CellType cellType = cellValue.getCellType();
				
				//Create a switch case and print the value
				switch (cellType) {
				case STRING:
					System.out.print(cellValue.getStringCellValue());;
					break;
				case NUMERIC:
					System.out.print(cellValue.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cellValue.getBooleanCellValue());
				}
				System.out.print("  ");
			}
			System.out.println(" ");
		}
		workbook.close();
	}

}
