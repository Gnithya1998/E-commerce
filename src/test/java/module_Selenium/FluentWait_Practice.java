package module_Selenium;

import java.awt.Window;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement fw = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {

				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {

					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				} else {
					return null;
				}

			}

		});

		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
		driver.close();
	}
}