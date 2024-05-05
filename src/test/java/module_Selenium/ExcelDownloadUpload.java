package module_Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelDownloadUpload {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExcelDownloadUpload obj = new ExcelDownloadUpload();
		
		String file = "C:\\Users\\Team EERO\\Downloads\\download.xlsx";
		int colNum = obj.getColNum(file, "Price");
		int rowNum = obj.getRowNum(file, "Mango");
		boolean success = updateCellValue(file, rowNum, colNum, "400");
		Assert.assertTrue(success);
		System.out.println("ColNum: " + colNum );
		System.out.println("RowNum: " + rowNum);

	}

	private int getColNum(String file, String price) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		Iterator<Row> rowIterator = sheet.rowIterator();
		Row row = rowIterator.next();
		
		int CellCount = row.getPhysicalNumberOfCells();
		
		for(int i=0; i<CellCount; i++) {
			
			String value = row.getCell(i).getStringCellValue();
			if(value.equalsIgnoreCase(price)) {
				
				return i;
			}
		}
				
		return 0;
	}
	

	private int getRowNum(String file, String fruit) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
//		Iterator<Row> rowIterator = sheet.rowIterator();
//		Row row = rowIterator.next();
//		int colCount = row.getPhysicalNumberOfCells();
		
		for(int i=0; i<rowCount; i++) {
			
			Row row = sheet.getRow(i);
			int colCount = row.getPhysicalNumberOfCells();
			for(int j=0; j<colCount; j++) {
				
				CellType type = row.getCell(j).getCellType();
				if(type==CellType.STRING) {
					
					Cell valCell = row.getCell(j);
					if(valCell.getStringCellValue().equalsIgnoreCase(fruit)) {
						
						return i;
					}
				}
				
				
			}
		}
		
		return 0;
	}
	
	private static boolean updateCellValue(String file, int rowNum, int colNum, String value) throws IOException {
		
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		cell.setCellValue(value);
		
		FileOutputStream os = new FileOutputStream(file);
		workbook.write(os);
		workbook.close();
		return true;
		
		
	}


}
