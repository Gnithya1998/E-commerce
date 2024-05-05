package module_ChromeDevTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.fetch.Fetch;
import org.openqa.selenium.devtools.v122.fetch.model.RequestId;
import org.openqa.selenium.devtools.v122.network.model.Request;

public class NetworkMock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Team EERO\\Documents\\drivers\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();

		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			Request res = request.getRequest();
			RequestId requestID = request.getRequestId();
			if (res.getUrl().contains("shetty")) {

				String mockUrl = res.getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockUrl);

				devTools.send(Fetch.continueRequest(requestID, Optional.of(mockUrl), Optional.empty(), Optional.empty(),
						Optional.empty(), Optional.empty()));

			} else {

				devTools.send(Fetch.continueRequest(requestID, Optional.empty(), Optional.empty(), Optional.empty(),
						Optional.empty(), Optional.empty()));

			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[contains(text(),'Library')]")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'only')]")).getText());
		driver.close();

	}

}
