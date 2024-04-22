package module_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='TRV']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		driver.findElement(By.cssSelector("*.ui-datepicker-today")).click();
		driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click();
		System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.cssSelector("div.paxinfo")).click();
		int passCount = 5;
		for (int i = 1; i < passCount; i++) {

			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		driver.close();

	}
}
