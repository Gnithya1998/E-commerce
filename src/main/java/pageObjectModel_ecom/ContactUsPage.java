package pageObjectModel_ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponentPack.AbstractComponent;

public class ContactUsPage extends AbstractComponent{

	WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Get')]")
	WebElement getInTouchTxt;
	
	@FindBy(name = "name")
	WebElement nameBox;
	
	@FindBy(xpath = "input[data-qa='email']")
	WebElement emailBox;
	
	@FindBy(name = "subject")
	WebElement subjectBox;
	
	@FindBy(css = "textarea#message")
	WebElement messageBox;
	
	@FindBy(name = "submit")
	WebElement submitBtn;
	
	public boolean getInTouchDisplay() {
		
		return getInTouchTxt.isDisplayed();
	}
	
	public void contactUSFormFill(String name, String email, String subject, String message) {
		
		nameBox.sendKeys(name);
		emailBox.sendKeys(email);
		subjectBox.sendKeys(subject);
		messageBox.sendKeys(message);
		submitBtn.click();
	}

	
}
