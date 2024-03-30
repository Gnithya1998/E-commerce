package baseTestPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel_ecom.HomePage;

public class BaseTestComponent {
	
	public WebDriver driver;
	public HomePage homePage;
	
	public WebDriver initialization() {
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod
	public HomePage SetUp() {
		
		driver = initialization();
		homePage = new HomePage(driver);
		homePage.goTo();
		return homePage;
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}

}
