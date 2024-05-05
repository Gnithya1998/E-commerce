package module_Selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		String downloadPath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ilovepdf.com/word_to_pdf");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Team EERO\\Documents\\AutoScripts\\fileuploadauto.exe");
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("processTask")))).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.downloader__btn"))).click();
		Thread.sleep(10000);
		File file = new File(downloadPath+ "/Resume_Nithyakalyani.pdf");
		if(file.exists()) {
			
			Assert.assertTrue(file.exists());
			if(file.delete()) {
				
				System.out.println("File has been deleted.");
			}
		}
		
		driver.close();
		
		
		

	}

}
