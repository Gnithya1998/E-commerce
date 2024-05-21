package pageObjectModel_ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponentPack.AbstractComponent;

public class TestCasePage extends AbstractComponent{
	
	public WebDriver driver;
	
	public TestCasePage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(tagName = "b")
	WebElement pageName;
	
	By testPageName = By.tagName("b");
	
	public boolean testCasePageVisibility() {
		
		waitForVisibilityOfElement(testPageName);
		if(pageName.getText().equalsIgnoreCase("Test Cases")) {
			
			return true;
		}else {
			
			return false;
		}
	}

}
