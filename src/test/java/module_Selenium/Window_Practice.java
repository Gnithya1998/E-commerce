package module_Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Practice {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int totalLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Total number of links present in the page: " + totalLinks);
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footerLinks = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Total number of links present in the footer section: " + footerLinks);
		
		WebElement firstTable = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int firstTableSize = firstTable.findElements(By.tagName("a")).size();
		System.out.println("First table size " + firstTableSize);
		
		for(int i=1; i< firstTableSize; i++) {
			
			String keyString = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			firstTable.findElements(By.tagName("a")).get(i).sendKeys(keyString);
			Thread.sleep(3000);
		}
		
		Set<String> windowToHandle = driver.getWindowHandles();
		Iterator<String> it = windowToHandle.iterator();
		
		while (it.hasNext()) {
			
			driver.switchTo().window(it.next());
			Thread.sleep(3000);
			System.out.println("Windows Title " + driver.getTitle());
			driver.close();
			
		}
	}

}
