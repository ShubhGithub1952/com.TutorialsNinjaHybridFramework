package apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelUsingIterator {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		path=path+"\\src\\test\\resources\\employees.xlsx";
		File file = new File(path);
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("collage");
			
			//create the method to load the row by using iterator method
			Iterator<Row> rowItr = sheet.iterator();
			while (rowItr.hasNext()) {
				Row row = rowItr.next();
				Iterator<Cell> cellItr = row.iterator();
				while (cellItr.hasNext()) {
					Cell cell = cellItr.next();
					CellType cellType = cell.getCellType();
					switch (cellType) {
						case STRING:
							System.out.print(cell.getStringCellValue());
							break;
							
						case BOOLEAN:
							System.out.print(cell.getBooleanCellValue());
							break;
						case NUMERIC:
							System.out.print(cell.getBooleanCellValue());
							break;
				        }
					System.out.print("  ");
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
