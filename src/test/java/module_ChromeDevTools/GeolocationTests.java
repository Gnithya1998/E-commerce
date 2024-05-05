package module_ChromeDevTools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class GeolocationTests {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("latitude", 55);
		params.put("longitude", 37);
		params.put("accuracy", 2);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", params);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElement(By.cssSelector("a[href='https://www.netflix.com/']")).click();
		System.out.println(driver.findElement(By.cssSelector("h1.e9eyrqp8")).getText());
		
		
		

	}

}
