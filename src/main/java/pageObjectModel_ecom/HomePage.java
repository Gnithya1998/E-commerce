package pageObjectModel_ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponentPack.AbstractComponent;

public class HomePage extends AbstractComponent{

	WebDriver driver;

	public HomePage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='/login']")
	WebElement signupBtn;
	
	@FindBy(css = "div[class='carousel-inner']")
	WebElement homeAds;

	public void goTo() {

		driver.get("http://automationexercise.com");
	}

	public RegistrationPage signupPage() {

		signupBtn.click();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		return registrationPage;
	}
	
	public boolean homePageVisibility() {
		
		boolean homeDisplay = homeAds.isDisplayed();
		return homeDisplay;
	}

}
