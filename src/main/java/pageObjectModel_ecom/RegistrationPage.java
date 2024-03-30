package pageObjectModel_ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseComponentPack.AbstractComponent;

public class RegistrationPage extends AbstractComponent {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='New User Signup!']")
	WebElement newUserText;

	@FindBy(name = "name")
	WebElement nameBox;

	@FindBy(css = "input[data-qa='signup-email']")
	WebElement emailBox;

	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signUpBox;

	@FindBy(xpath = "//h2/b[contains(text(),'Account Info')]")
	WebElement accInfoTxt;

	@FindBy(id = "id_gender1")
	WebElement mrRadioBtn;

	@FindBy(id = "id_gender2")
	WebElement mrsRadioBtn;

	@FindBy(id = "password")
	WebElement passswBox;

	@FindBy(css = "select#days")
	WebElement daysBox;

	@FindBy(xpath = "//select[@name='months']")
	WebElement monthsBox;

	@FindBy(name = "years")
	WebElement yearsBox;

	@FindBy(css = "input[name='newsletter']")
	WebElement newsletterCheckBox;

	@FindBy(xpath = "//input[@id='optin']")
	WebElement offersCkeckBox;
	
	@FindBy(xpath = "//h2/b[contains(text(),'Address ')]")
	WebElement addressInfoTxt;
	
	@FindBy(css = "input#first_name")
	WebElement firstNameBox;
	
	@FindBy(id = "last_name")
	WebElement lastNameBox;
	
	@FindBy(name = "address1")
	WebElement addressBox;
	
	@FindBy(css = "select#country")
	WebElement countrySelect;
	
	@FindBy(id = "state")
	WebElement stateBox;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement cityBox;
	
	@FindBy(id = "zipcode")
	WebElement zipcodeBox;
	
	@FindBy(css = "input#mobile_number")
	WebElement mobileNumBox;
	
	@FindBy(css = "button[data-qa='create-account']")
	WebElement createBtn;
	
	@FindBy(xpath = "//h2/b")
	WebElement accCreatedTxt;
	
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement cntBtn;

	public String newUserSignUp() {

		return newUserText.getText();
	}

	public void signUp(String name, String email) {

		nameBox.sendKeys(name);
		emailBox.sendKeys(email);
		signUpBox.click();

	}

	public boolean accInfoMsg() {

		return accInfoTxt.isDisplayed();
	}

	public void accountInformationForm(String name, String email, String password) {

		mrsRadioBtn.click();
		passswBox.sendKeys(password);
		Select daySelect = new Select(daysBox);
		daySelect.selectByValue("30");
		Select monthSelect = new Select(monthsBox);
		monthSelect.selectByVisibleText("August");
		Select yearsSelect = new Select(yearsBox);
		yearsSelect.selectByValue("1998");
		newsletterCheckBox.click();
		offersCkeckBox.click();
		
	}
	
	public boolean addressInfoMsg() {
		
		return addressInfoTxt.isDisplayed();
	}
	
	public void addressInformationForm(String name) {
		
		firstNameBox.sendKeys(name);
		lastNameBox.sendKeys("Manick");
		addressBox.sendKeys("IIT Madras");
		Select crtSelect = new Select(countrySelect);
		crtSelect.selectByVisibleText("India");
		stateBox.sendKeys("Chennai");
		cityBox.sendKeys("Chennai");
		zipcodeBox.sendKeys("600 036");
		mobileNumBox.sendKeys("1234567890");
		createBtn.click();
	}
	
	public boolean accCreatedMsg() {
		
		return accCreatedTxt.isDisplayed();
	}
	
	public void homeNavigation() {
		
		cntBtn.click();
	}
	
	
	
	

}
