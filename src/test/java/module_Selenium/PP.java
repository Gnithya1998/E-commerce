package module_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PP {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\Users\\Team EERO\\Documents\\DataSheet.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("Flower");
		int rowCount = sheet.getPhysicalNumberOfRows();
	
		//For printing values in row
		
//		for(int i=0; i<rowCount; i++) {
//			
//			XSSFRow row = sheet.getRow(i);
//			XSSFCell cell = row.getCell(0);
//			String cellString = cell.getStringCellValue();
//			
//			if(cellString.equals("Colour")) {
//				
//				int cellCount = row.getPhysicalNumberOfCells();
//				for(int j=1; j<cellCount; j++) {
//					
//					cell = row.getCell(j);
//					System.out.println(cell.getStringCellValue());
//				}
//			}
//			
//		}
		
		//For printing values in column
		
		int col = 0;
		XSSFRow row = sheet.getRow(0);
		int cellCount = row.getPhysicalNumberOfCells();
		
		for(int i=0; i<cellCount; i++) {
			
			XSSFCell cell = row.getCell(i);
			String cellString = cell.getStringCellValue();
			if(cellString.equals("Rose")) {
				
				col = i;
				System.out.println(col);
			}
		}
		
		for(int j=0; j<rowCount; j++) {
		
		row = sheet.getRow(j);
	    XSSFCell cell = row.getCell(col);
		System.out.println(cell.getStringCellValue());
	}
		

	}

}
