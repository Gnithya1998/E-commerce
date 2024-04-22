package module_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel_DataProvider {
	
	DataFormatter formatter = new DataFormatter();
	
	

	@Test(dataProvider = "Handle data")
	public void dataTest(String mood, String handle, String visit) throws IOException {
		
		System.out.println(mood + " " + handle + " " + visit);
	}
	
	@DataProvider(name = "Handle data")
	public Object[][] setData() throws IOException {
		File file = new File("C:\\Users\\Team EERO\\Documents\\DataSheet.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("Handle sheet");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object[][] data = new Object[rowCount-1][colCount];
		for(int i=0; i<rowCount-1; i++) {
			
			System.out.println("Outerloop started");
			row = sheet.getRow(i+1);
			for(int j=0; j<colCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
				System.out.println(cell);
			}
			
			System.out.println("Outerloop ended");
		}
		
		return data;
	}
}
