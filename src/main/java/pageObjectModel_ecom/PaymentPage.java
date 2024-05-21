package pageObjectModel_ecom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "name_on_card")
	WebElement cardName;
	
	@FindBy(css = "input.card-number")
	WebElement cardNumber;
	
	@FindBy(xpath = "//input[@data-qa='cvc']")
	WebElement cardCVV;
	
	@FindBy(name = "expiry_month")
	WebElement cardMonth;
	
	@FindBy(name = "expiry_year")
	WebElement cardYear;
	
	@FindBy(id = "submit")
	WebElement confirmOrder;
	
	@FindBy(xpath = "//p[contains(text(),'Your order')]")
	WebElement orderSuccess;

	public void cardDetails(String name, String number, String cvv, String month, String year) {
		
		cardName.sendKeys(name);
		cardNumber.sendKeys(number);
		cardCVV.sendKeys(cvv);
		cardMonth.sendKeys(month);
		cardYear.sendKeys(year);
		confirmOrder.click();
		
	}
	
	public String orderSuccessMsg() {
		
		return orderSuccess.getText();
	}
}
