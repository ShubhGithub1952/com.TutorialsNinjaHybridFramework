package apachePOI;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTheDataIntoExcel2 {
	public static void main(String[] args) {
		try {
			//Create the object of workbook and creat a sheet to store the values
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Admission");
			
			Object [][]school= {{"SchoolName", "StudentName", "Standard", "Age", "Gender"},
			          {"Oxford School", "Satish", 5, 13, "Male"},
			          {"Primary School", "Shivani", 6, 14, "Female"},
			          {"Sant Tukdoba School", "Aarohi", 4, 12, "Female"},
			          {"Sent Merry School", "Shantanu", 7, 17, "Male"},
			          {"Shahu School","Atul Setu", 12, 22, "Male"}};
			
				//Create a container for row and column
				int iRow=school.length;
				int iColumn=school[0].length;
			
				//Create the for loop and store the element of object array
				for (int r = 0; r < iRow; r++) {
					
					//call the method to create the row using sheet ref veriable
				   XSSFRow row = sheet.createRow(r);
				   
					   for (int c = 0; c < iColumn; c++) {
						   
					   //call the to create cell using row ref veriable
						XSSFCell cell = row.createCell(c);
						
					  //As row and cell created and now store the row and column data of object array
						Object datavalue = school[r][c];
						
						//Now apply condition if datavalue is String, Integer or Boolean
						if (datavalue instanceof String) {
							cell.setCellValue((String)datavalue);
						} 
						else if (datavalue instanceof Integer) {
							cell.setCellValue((Integer)datavalue);
						} 
						else if (datavalue instanceof Boolean) {
							cell.setCellValue((Boolean)datavalue);
						}
					}
	        }
			
				//Create the object of file to store the path
				File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\school.xlsx");
				
				//Create the object of fileOutputStream to store data
				FileOutputStream fileOutput = new FileOutputStream(file);
				
				//now store the fileoutput stream object ref into the workbook write method
				workbook.write(fileOutput);
				System.out.println("Task completed");
				workbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
