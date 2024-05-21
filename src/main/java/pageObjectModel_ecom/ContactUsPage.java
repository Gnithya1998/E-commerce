package pageObjectModel_ecom;

import java.io.IOException;

import org.openqa.selenium.By;
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
	
	@FindBy(css = "input[data-qa='email']")
	WebElement emailBox;
	
	@FindBy(name = "subject")
	WebElement subjectBox;
	
	@FindBy(css = "textarea#message")
	WebElement messageBox;
	
	@FindBy(name = "submit")
	WebElement submitBtn;
	
	@FindBy(css = "div.alert-success")
	WebElement successMsg;
	
	@FindBy(linkText = "Home")
	WebElement homeLink;
	
	public boolean getInTouchDisplay() {
		
		return getInTouchTxt.isDisplayed();
	}
	
	public void contactUSFormFill(String name, String email, String subject, String message) throws IOException, InterruptedException {
		
		nameBox.sendKeys(name);
		emailBox.sendKeys(email);
		subjectBox.sendKeys(subject);
		messageBox.sendKeys(message);
		Thread.sleep(4000);
		Runtime.getRuntime().exec("C:\\Users\\Team EERO\\Documents\\AutoScripts\\automationExercise.exe");
		submitBtn.click();
	}
	
	public void switchToAlertSays() {
		
		driver.switchTo().alert().accept();
	}
	
	public String contactSuccessMsg() {
		
		return successMsg.getText();
	}
	
	public void switchToHomePage() {
		
		homeLink.click();
	}

	
}
