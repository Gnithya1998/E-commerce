package module_Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.bouncycastle.tsp.TimeStampTokenInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabWindowHandle_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
		driver.get("https://www.rahulshettyacademy.com/");
		Thread.sleep(3000);

		String name = driver.findElements(By.cssSelector("[href*='https://courses.rahulshettyacademy.com/p']")).get(1)
				.getText();
		System.out.println(name);

		driver.switchTo().window(parentWindow);
		WebElement nameBox = driver.findElement(By.name("name"));
		nameBox.sendKeys(name);
		
		driver.quit();

	}

}
