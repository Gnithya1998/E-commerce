package module_Selenium;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test1_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] items = { "Brocolli", "Carrot", "Tomato" };
		int count = 0;

		List<WebElement> itemsPresent = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < itemsPresent.size(); i++) {

			String[] name = itemsPresent.get(i).getText().split("-");
			String actualName = name[0].trim();

			List<String> itemsList = Arrays.asList(items);

			if (itemsList.contains(actualName)) {

				count++;

				driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
				Thread.sleep(5000);

				if (count == 3) {

					break;
				}

			}

		}

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".promoCode"))).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".promoInfo")));
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.findElement(By.xpath("//select[contains(@style,'width')]")).click();
		WebElement element = driver.findElement(By.xpath("//select[contains(@style,'width')]"));
		Select options = new Select(element);
		options.selectByVisibleText("India");
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		String outputMsg = driver.findElement(By.cssSelector(".wrapperTwo")).getText();
//		Assert.assertEquals(outputMsg, "Thank you, your order has been placed successfully You'll be redirected to Home page shortly!!");
		driver.close();

	}

}
