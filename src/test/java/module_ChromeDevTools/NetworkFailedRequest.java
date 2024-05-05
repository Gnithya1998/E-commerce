package module_ChromeDevTools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.fetch.Fetch;
import org.openqa.selenium.devtools.v122.fetch.model.RequestId;
import org.openqa.selenium.devtools.v122.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v122.network.model.ErrorReason;
import org.openqa.selenium.devtools.v122.network.model.Request;

public class NetworkFailedRequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		Optional<List<RequestPattern>> patterns =Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request->
		{
			Request res = request.getRequest();
			RequestId requestID = request.getRequestId();
			devTools.send(Fetch.failRequest(requestID, ErrorReason.FAILED));
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[contains(text(),'Library')]")).click();
		Thread.sleep(3000);

	}

}
