package module_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import org.apache.poi.ss.format.CellTextFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Apach_poi_case1 {

	@Test
	public void dataDrivenTesting() throws IOException {

		ArrayList data = (ArrayList) getData("E-Commerce", "Testdata", "Login");

		for (int i = 0; i < data.size(); i++) {

			System.out.println(data.get(i));
		}
	}

	public Object getData(String sheetName, String testCase, String testValues) throws IOException {

		ArrayList<String> arr = new ArrayList<>();

		// Setting up the file and workbook
		File file = new File("C:\\Users\\Team EERO\\Documents\\DataSheet.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

		// Obtaining the number of sheet in the workbook
		int sheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetCount; i++) {

			// Using for loop fetching the desired sheet.
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				// Iterating and obtaining the firstRow of the sheet.
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();

				// Iterating through the cells to get the column index.
				Iterator<Cell> cells = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {

					Cell cellValue = cells.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase(testCase)) {

						column = k;
					}

					k++;
				}

				// Iterating through rows in the column to print the values in the row.
				while (rows.hasNext()) {

					Row rowValue = rows.next();
					if (rowValue.getCell(column).getStringCellValue().equalsIgnoreCase(testValues)) {

						// Again iterating through the cells to obtain the cells data
						Iterator<Cell> cv = rowValue.cellIterator();
						while (cv.hasNext()) {

							Cell c = cv.next();
							if (c.getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {

								arr.add(c.getStringCellValue());

							} else {

								arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}

				}
			}
		}

		return arr;

	}

}
