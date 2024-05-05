package module_ChromeDevTools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		//Since we need to invoke the Chrome DevTools Protocol(CDP) create a ChromeDriver instead of WebDriver
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		
		//Create a session for the DevTools to start
		devTools.createSession();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("width", 600);
		params.put("height", 1000);
		params.put("deviceScalerFactor", 45);
		params.put("mobile", true);
			
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button.navbar-toggler")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();

	}

}
