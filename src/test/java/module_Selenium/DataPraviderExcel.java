package module_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Iterator;

import javax.swing.text.DateFormatter;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPraviderExcel {
	
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "Data")
	public void test(String name, String color, String fav, String height, int price) {

		System.out.println(name +" "+color+" "+fav+" "+height);
	}

	@DataProvider(name = "Data")
	public Object[][] getData() throws IOException {

		File file = new File("C:\\Users\\Team EERO\\OneDrive\\Documents\\DataSheet.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("Trees");

		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getPhysicalNumberOfCells();
		System.out.println(colCount);
		
		Object[][] data = new Object[rowCount-1][colCount];
		for(int i=0; i<rowCount-1; i++) {
			
			row = sheet.getRow(i+1);
			for(int j=0; j<colCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		
		return data;
	}

}
