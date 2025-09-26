package apachePOI;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTheDataIntoExcel3 {
	public static void main(String[] args) {
		//Create a workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Bike");
		
		Object [][]temp= {{"Company", "Name", "Price", "Color","CC"},
				          {"Hero","Spelndor",75000,"Black", 100},
				          {"Honda","Shine",120000,"Silver",125},
				          {"Royal Enfiled", "Bullet",215000,"RoyalBlack", 350},
				          {"Yamaha","MT15",180000,"Blue", 150},
				          {"Aprila", "Trigger",230000,"RedBlack",250},
				          {"Harly Davidson","Tobber", 280000,"Black",350}};
		
		int iRow = temp.length;
		int iColumn = temp[0].length;
		
		//Create a for loop store value in row and column
		for (int r = 0; r < iRow; r++) {
			XSSFRow row = sheet.createRow(r);
			
			for (int c = 0; c < iColumn; c++) {
				XSSFCell cell = row.createCell(c);
				Object dataValue = temp[r][c];
				if (dataValue instanceof String) {
					cell.setCellValue((String)dataValue);
				} 
				else if(dataValue instanceof Integer) {
					cell.setCellValue((Integer)dataValue);
				}
				else if (dataValue instanceof Boolean) {
					cell.setCellValue((Boolean)dataValue);
				}
			}
		}
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Bike.xlsx");
		try {
			FileOutputStream fOut = new FileOutputStream(file);
			workbook.write(fOut);
			workbook.close();
			System.out.println("Update Completed !!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
