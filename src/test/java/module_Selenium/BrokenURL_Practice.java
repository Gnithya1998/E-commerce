package module_Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class BrokenURL_Practice {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SoftAssert as = new SoftAssert();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link : links) {

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();

			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			as.assertTrue(responseCode < 400,
					"This link " + link.getText() + " is a broken link with code " + responseCode);

		}
		
		driver.close();

	}

}
