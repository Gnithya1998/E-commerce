package module_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Practice {

	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement element = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select options = new Select(element);
		options.selectByIndex(1);
		System.out.println(options.getFirstSelectedOption().getText());
		options.selectByVisibleText("AED");
		System.out.println(options.getFirstSelectedOption().getText());
		options.selectByValue("USD");
		System.out.println(options.getFirstSelectedOption().getText());
		driver.close();
	}

}
