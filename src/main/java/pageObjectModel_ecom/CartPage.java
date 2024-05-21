package pageObjectModel_ecom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponentPack.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	RegistrationPage registrationPage;
	CheckoutPage checkoutPage;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div.footer-widget")
	WebElement footerSection;
	
	@FindBy(css = "div.single-widget h2")
	WebElement subscribElement;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailElement;
	
	@FindBy(id = "subscribe")
	WebElement subscribeBtn;
	
	@FindBy(css = "div.alert-success")
	WebElement subscribeMsg;
	
	@FindBy(xpath = "//tbody//td[@class='cart_description']//a")
	List<WebElement> cartDiscription;
	
	@FindBy(css = "tbody td:nth-of-type(4) button")
	WebElement quantityValue;
	
	@FindBy(css = "a.check_out")
	WebElement proceedToCheckout;
	
	@FindBy(linkText = "Register / Login")
	WebElement regLoginBtn;
	
	
	public String cartUrl() {
		
		return driver.getCurrentUrl();
	}
	
	
	public String subscribeCart() {
		
		scrollToElement(footerSection);
		return subscribElement.getText();
		
	}
	
	public String subscribeSuccessMsg(String email) {
		
		emailElement.sendKeys(email);
		subscribeBtn.click();
		return subscribeMsg.getText();
		
	}
	
	public List<String> productsInCart() {
		
		List<String> nameStrings = new ArrayList<String>();
		
		for(WebElement e: cartDiscription) {
			
		    String s = e.getText();
		    nameStrings.add(s);
		}
		
		return nameStrings;
	}
	
	public String checkProdQuantity() {
		
		return quantityValue.getText();
	}
	
	public CheckoutPage checkOutBtn() {
		
		proceedToCheckout.click();
		
		try {
			
			regLoginBtn.click();
		} catch (Exception e) {
			
			System.out.println("User already registered");
		}
		
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	public RegistrationPage getRegisterPage() {
		
		registrationPage = new RegistrationPage(driver);
		return registrationPage;
	}
	
	public void removeItems(int[] removeIds) {
		
		for(int i=0; i<removeIds.length; i++) {
			
			WebElement element = driver.findElement(By.xpath("//tr[@id='product-"+removeIds[i]+"']"));
			element.findElement(By.cssSelector("a.cart_quantity_delete")).click();
		}
	}

}
