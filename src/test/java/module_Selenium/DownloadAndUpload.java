package module_Selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DownloadAndUpload {

	public static void main(String[] args) throws IOException {

		String prod = "Mango";
		String price = "";
		String value = "458";

		// Invoking drivers
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

		// Webdriver wait to open the page
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container")));

		// Java script to enter the particular element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		// Download button
		WebElement downloadBtn = driver.findElement(By.id("downloadButton"));
		downloadBtn.sendKeys(Keys.ENTER);

		//Uploading the sheet with new price value
		DownloadAndUpload obj = new DownloadAndUpload();
		String file = "C:\\Users\\Team EERO\\Downloads\\download.xlsx";
		int colNum = getColNum(file, "Price");
		int rowNum = getRowNum(file, prod);
		boolean success = updateCellValue(file, rowNum, colNum, value);
		Assert.assertTrue(success);
		System.out.println("ColNum: " + colNum);
		System.out.println("RowNum: " + rowNum);

		// Upload button
		WebElement uploadBtn = driver.findElement(By.cssSelector("input[type='file']"));
		uploadBtn.sendKeys("C:\\Users\\Team EERO\\Downloads\\download.xlsx");

		//Checking update is successful
		By uploadMsg = By.cssSelector("div.Toastify__toast-body div:last-child");
		wait.until(ExpectedConditions.visibilityOfElementLocated(uploadMsg));
		String uploadText = driver.findElement(uploadMsg).getText();
		System.out.println(uploadText);
		Assert.assertEquals("Updated Excel Data Successfully.", uploadText);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(uploadMsg));

		//Fetching to updated price to check if it is correct. 
		List<WebElement> colorElements = driver
				.findElements(By.cssSelector("div.rdt_TableBody div.rdt_TableRow div[data-column-id='2']"));
		for (WebElement element : colorElements) {

			if (element.getText().equalsIgnoreCase(prod)) {

				String priceID = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
				WebElement numElement = driver.findElement(By.xpath("//div[@data-column-id='2']//div[contains(text(),'"
						+ prod + "')]//following::div[@data-column-id='" + priceID + "']"));
				price = numElement.getText();
				System.out.println(price);
				Assert.assertEquals(value, price);
			}
		}
		driver.navigate().refresh();

		// Close the driver
		driver.quit();

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

	public static int getColNum(String file, String price) throws IOException {

		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();

		Iterator<Row> rowIterator = sheet.rowIterator();
		Row row = rowIterator.next();

		int CellCount = row.getPhysicalNumberOfCells();

		for (int i = 0; i < CellCount; i++) {

			String value = row.getCell(i).getStringCellValue();
			if (value.equalsIgnoreCase(price)) {

				return i;
			}
		}

		return 0;
	}

	public static int getRowNum(String file, String fruit) throws IOException {

		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < rowCount; i++) {

			Row row = sheet.getRow(i);
			int colCount = row.getPhysicalNumberOfCells();
			for (int j = 0; j < colCount; j++) {

				CellType type = row.getCell(j).getCellType();
				if (type == CellType.STRING) {

					Cell valCell = row.getCell(j);
					if (valCell.getStringCellValue().equalsIgnoreCase(fruit)) {

						return i;
					}
				}

			}
		}

		return 0;
	}

}
