package apachePOI;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTheDataIntoExcel1 {
	public static void main(String[] args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheetOne = workbook.createSheet("SheetOne");
		
		//Now Create the object and store the data
		Object [] [] data= {{"Name", "Location", "Experience", "Gender"},
				{"Google Pixel", "India", 26, "Male"},
				{"Samsung Galaxy","USA", 29,"Female"},
				{"Oneplus Nord","China", 32, "Female"},
				{"RedMi Poco", "Bihar",34,"Male"}
				};
		
				int rows= data.length;
				int columns=data[0].length;
				
				for (int i = 0; i <rows; i++) {
					XSSFRow row = sheetOne.createRow(i);
					
					for (int j = 0; j < columns; j++) {
						XSSFCell cell = row.createCell(j);
						Object cellValue = data[i][j];
						if (cellValue instanceof String) {
							cell.setCellValue((String)cellValue);
						}else if (cellValue instanceof Integer) {
							cell.setCellValue((Integer)cellValue);
						}else if (cellValue instanceof Boolean) {
							cell.setCellValue((Boolean)cellValue);
						}
					}
				}
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\writeData.xlsx");
		try {
			FileOutputStream fileOutput = new FileOutputStream(file);
			workbook.write(fileOutput);
			workbook.close();
			System.out.println("Task completed !!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
