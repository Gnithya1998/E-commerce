package module_Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll_Practice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Scroll to the table
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		// Scroll inside the table
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");

		List<WebElement> tableData = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr/td[4]"));
		int Sum = 0;
		for (int i = 0; i < tableData.size(); i++) {

			Sum = Sum + Integer.parseInt(tableData.get(i).getText());
		}

		int totalSum = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(Sum, totalSum);

		driver.close();

	}

}
