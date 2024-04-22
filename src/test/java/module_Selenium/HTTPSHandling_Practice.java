package module_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPSHandling_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

		driver.close();

	}

}
