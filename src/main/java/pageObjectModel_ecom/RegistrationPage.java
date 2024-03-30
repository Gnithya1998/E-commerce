package pageObjectModel_ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(name = "email")
	WebElement emailBox;
	
	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signUpBox;
	
	
	public String newUserSignUp() {
		
		return newUserText.getText();
	}
	
	public void signUp() {
		
		nameBox.sendKeys("Bashaa");
		emailBox.sendKeys("bashaa456@gmail.com");
		signUpBox.click();
		
	}
	
	
	
	
	

	

}
