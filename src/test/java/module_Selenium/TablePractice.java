package module_Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TablePractice {

	@Test
	public void main() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		List<WebElement> salaryElements = driver.findElements(By.xpath("//table//tbody//tr//td[5]"));
		
		int sum = 0;
		
		for(WebElement e: salaryElements) {
			
			int val = Integer.parseInt( e.getText());	
			System.out.println(val);
			sum += val;
		}
		
		System.out.println(sum);

	}

}
