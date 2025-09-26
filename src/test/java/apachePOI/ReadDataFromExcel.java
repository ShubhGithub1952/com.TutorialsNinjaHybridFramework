package apachePOI;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	public static void main(String[] args) throws Exception {
		//Provide the path to the file to read data
		String path=System.getProperty("user.dir");
		path=path+"//src//test//resources//TutorialsNinjaCred.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("emp");
		int lastRow = sheet.getLastRowNum();
		//System.out.println(lastRow);
		for (int row = 0; row < lastRow; row++) {
			XSSFRow row1 = sheet.getRow(row);
			int cellCount = row1.getLastCellNum();
			for (int cell = 0; cell < cellCount; cell++) {
				XSSFCell cellvalue = row1.getCell(cell);
				CellType cellType = cellvalue.getCellType();
				switch (cellType) {
				case STRING:
					System.out.print(cellvalue.getStringCellValue()+", ");
					break;

				case NUMERIC:
					System.out.print(cellvalue.getNumericCellValue()+", ");
					break;
				case BOOLEAN:
					System.out.print(cellvalue.getBooleanCellValue()+", ");
					break;
				}
				System.out.print("  ");
			}
			System.out.println();
		}
		workbook.close();
	}

}
