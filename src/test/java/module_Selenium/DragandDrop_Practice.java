package module_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragandDrop_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement source = driver.findElement(By.xpath("//ul[@id='gallery']/child::li[1]"));
		WebElement destination = driver.findElement(By.id("trash"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(source, destination).build().perform();
		driver.switchTo().defaultContent();
		
		act.moveToElement(driver.findElement(By.name("s"))).click().keyDown(Keys.SHIFT).sendKeys("heml").build().perform();
		
		driver.close();

	}

}
