package module_Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calender_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String month = "8";
		String date = "15";
		String year = "2029";
		
		String[] dateString = {month,date,year};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		WebElement findYear = driver.findElement(By.xpath("//button[text()="+year+"]"));
		findYear.click();
		driver.findElement(By.cssSelector(".react-calendar__year-view__months__month:nth-child("+month+")")).click();
		driver.findElement(By.xpath("//button/abbr[text()='"+date+"']")).click();
		
		List<WebElement> values = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i=0; i<values.size(); i++) {
			
			String currentValue = values.get(i).getAttribute("value");			
			Assert.assertEquals(currentValue, dateString[i]);
				
			}
		driver.close();
		}

	}
