package pageObjectModel_ecom;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//h2[contains(text(),'Login')]")
	WebElement loginUserTxt;

	@FindBy(name = "email")
	WebElement loginEmail;

	@FindBy(css = "input[data-qa='login-password']")
	WebElement pswBox;

	@FindBy(css = "button[data-qa='login-button']")
	WebElement loginBtn;

	@FindBy(css = "p[style='color: red;']")
	WebElement errorMsg;

	By incorrectMsgBy = By.cssSelector("p[style='color: red;']");

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

	public void addressInformationForm(String name, String lastname, String address, String country, String state,
			String city, String zipcode, String mobileNum) {

		firstNameBox.sendKeys(name);
		lastNameBox.sendKeys(lastname);
		addressBox.sendKeys(address);
		Select crtSelect = new Select(countrySelect);
		crtSelect.selectByVisibleText(country);
		stateBox.sendKeys(state);
		cityBox.sendKeys(city);
		zipcodeBox.sendKeys(zipcode);
		mobileNumBox.sendKeys(mobileNum);
		createBtn.click();
	}

	public boolean accCreatedMsg() {

		return accCreatedTxt.isDisplayed();
	}

	public void homeNavigation() {

		cntBtn.click();
	}

	public String userLogin() {

		String loginUserMsg = loginUserTxt.getText();
		return loginUserMsg;
	}

	public void Login(String email, String password) {

		loginEmail.sendKeys(email);
		pswBox.sendKeys(password);
		loginBtn.click();
	}

	public String errorMsgElement() {

		waitForElementToBePresent(incorrectMsgBy);
		return errorMsg.getText();
	}

}
