package pageObjectModel_ecom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponentPack.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	RegistrationPage registrationPage;
	PaymentPage paymentPage;

	public CheckoutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "address_delivery")
	WebElement deliveryAddress;
	
	@FindBy(id = "address_invoice")
	WebElement billingAddress;
	
	@FindBy(css = "div.cart_info")
	WebElement cartInfo;
	
	@FindBy(name = "message")
	WebElement messageBox;
	
	@FindBy(linkText = "Place Order")
	WebElement placeOrderBtn;
	
	public boolean addressDisplay() {
		
		if(deliveryAddress.isDisplayed() && billingAddress.isDisplayed()) {
			
			return true;
		}else {
			
			return false;
		}
	}
	
	public boolean cartDiaplayed() {
		
		return cartInfo.isDisplayed();
	}
	
	public PaymentPage ClickPlaceOrder(String message) {
		
		messageBox.sendKeys(message);
		placeOrderBtn.click();
		paymentPage = new PaymentPage(driver);
		return paymentPage;
		
	}
	


}
