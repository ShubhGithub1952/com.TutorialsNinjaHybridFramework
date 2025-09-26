package apachePOI;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel3 {
	public static void main(String[] args) {
		//Create user directory path and pass into the File object
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\employees.xlsx");
		
		//Create the file inputStream object and pass file object reference
		try {
			FileInputStream fis = new FileInputStream(file);
			
			//Create the object of workbook and pass inputStream object
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//now pass the Sheet name into the Sheet method to read data
			XSSFSheet sheet = workbook.getSheet("emp");
			
			//Now get the count of row available in sheet to iterrate the for loop
			int rowCount = sheet.getLastRowNum();
			for (int r = 0; r < rowCount; r++) {
				//now Create the object of row
				XSSFRow row = sheet.getRow(r);
				
				//now get the count of cell
				short cellCount = row.getLastCellNum();
				
				//now create the for loop and create a cell object and write the switch loop to fetch value
				for (int c = 0; c < cellCount; c++) {
					XSSFCell cellValue = row.getCell(c);
					
					//We got the Cell value but the value could be either String/Boolean/Numeric so 
					//Create the object of cellDataType and by using switch method print it
					CellType celltype = cellValue.getCellType();
					switch (celltype) {
					case STRING:
						System.out.print(cellValue.getStringCellValue()+" ");
						break;

					case BOOLEAN:
						System.out.print(cellValue.getBooleanCellValue()+" ");
						break;
						
					case NUMERIC:
						System.out.print(cellValue.getNumericCellValue()+" ");
						break;
					}
				}
				System.out.println();
			}
			
			workbook.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
