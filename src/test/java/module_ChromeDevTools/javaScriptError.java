package module_ChromeDevTools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class javaScriptError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("a.btn-success")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector("button.add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
		List<org.openqa.selenium.logging.LogEntry> logsEntries = entry.getAll();
		for(LogEntry e: logsEntries) {
			
			System.out.println(e.getMessage());
		}
		
		

	}

}
