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
	
	@FindBy(xpath = "//a/child::b")
	WebElement userNameTxt;
	
	@FindBy(css = "a[href='/delete_account']")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//h2/b")
	WebElement deleteMsgElement;
	
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement ctnBtn;
	
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutBtn;
	
	@FindBy(css = "a[href='/contact_us']")
	WebElement contactUsLink;

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
	
	public String usernameCheck() {
		
		String userString = userNameTxt.getText();
		return userString;
	}
	
	public boolean deleteAcc() {
		
		deleteBtn.click();
		return deleteMsgElement.isDisplayed();
		
	}
	
	public void cntBtnClick() {
		
		ctnBtn.click();
	}
	
	public void logoutAcc() {
		
		logoutBtn.click();
	}
	
	public ContactUsPage contactUs() {
		
		contactUsLink.click();
		ContactUsPage contactUsPage = new ContactUsPage(driver);
		return contactUsPage;
	}
	
	

}
