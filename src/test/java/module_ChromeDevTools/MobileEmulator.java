package module_ChromeDevTools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.emulation.Emulation;


public class MobileEmulator {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		//Since we need to invoke the Chrome DevTools Protocol(CDP) create a ChromeDriver instead of WebDriver
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		
		//Create a session for the DevTools to start
		devTools.createSession();
		
		//Send command to CDP methods--> CDP methods will invoke the Chrome DevTools Protocol
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 45, true, null, null, null, null, null, null, null, null, null, null));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button.navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();

	}

}
