package module_Selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

public class Excel {
	
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider = "data")
	public void excelData(String mood, String handle, int visites){
		
		System.out.println(mood);
		
		
	}
	
	@DataProvider(name="data")
	public Object[][] getData() throws IOException {
		
		String file = "C:\\Users\\Team EERO\\OneDrive\\Documents\\DataSheet.xlsx";
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("Handle sheet");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		
		int colCount = row.getPhysicalNumberOfCells();
		Object[][] dataSet = new Object[rowCount-1][colCount];
		
		for(int i=0; i<rowCount-1; i++) {
			
			row = sheet.getRow(i+1);
			for(int j=0; j<colCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				dataSet[i][j]= formatter.formatCellValue(cell);
			}
		}
	return dataSet;	
	}
	
	

}
