package apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelUsingIterator1 {
	public static void main(String[] args) {
		//Create the object of file and pass the user directory path
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\employees.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("collage");
			Iterator<Row> rowItr = sheet.iterator();
			while (rowItr.hasNext()) {
				Row row = rowItr.next();
				Iterator<Cell> cellItr = row.iterator();
				while (cellItr.hasNext()) {
					Cell cell = cellItr.next();
					CellType cellType = cell.getCellType();
					switch (cellType) {
					case STRING:
						System.out.print(cell.getStringCellValue()+" ");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue()+" ");
						break;

					case NUMERIC:
						System.out.print(cell.getNumericCellValue()+" ");
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
