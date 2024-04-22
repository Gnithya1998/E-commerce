package module_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSelect_Practice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("au");
		Thread.sleep(3000);
		List<WebElement> elements = driver.findElements(By.cssSelector("li[role='presentation'] a"));
		for (WebElement s : elements) {

			if (s.getText().equalsIgnoreCase("Australia")) {

				s.click();
			}
		}

		driver.close();

	}

}
