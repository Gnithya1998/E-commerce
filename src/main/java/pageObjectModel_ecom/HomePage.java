package pageObjectModel_ecom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.NavigationResult;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponentPack.AbstractComponent;

public class HomePage extends AbstractComponent{

	WebDriver driver;
	int[] ids = {2,7,8,10,6};
	List<String> productsName = new ArrayList<>();
	
	

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
	
	@FindBy(linkText = "Test Cases")
	WebElement testCasesLink;
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement productsLink;
	
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
	
	@FindBy(partialLinkText = "Cart")
	WebElement cartLink;
	
	@FindBy(css = "div.product-information")
	WebElement prodInfo;
	
	@FindBy (css = "button.cart")
    WebElement addToCartBtn;
    
    @FindBy(css = "button.btn-block")
    WebElement continueShoppingBtn;
    
    @FindBy(xpath = "//div[@class='icon-box']//following::div[@class='modal-body']//a")
    WebElement viewCart;
    
    @FindBy(css = "div.category-products")
    WebElement categoryElement;
    
    @FindBy(css = "a[href='#Women'] span.badge.pull-right")
    WebElement womenCategoryElement;
    
    @FindBy(css = "div.recommended_items")
    WebElement recomItemsTabElement;
    
    @FindBy(id = "recommended-item-carousel")
    WebElement recomItemsID;
    
    
   
    
    
//    @FindBy(xpath = )
//    WebElement productId;
//	

    By viewProdBy = By.linkText("View Product");
    By quantityBy = By.name("quantity");
    By womenIdBy = By.xpath("//div[@id='Women']//li");
    By titleBy = By.cssSelector("h2.title");
	
	
	
	
	
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
	
	public TestCasePage TestCases() {
		
		testCasesLink.click();
		TestCasePage testCasePage = new TestCasePage(driver);
		return testCasePage;
	}
	
	public ProductsPage getProductPage() {
		
		productsLink.click();
		ProductsPage productsPage = new ProductsPage(driver);
		return productsPage;
	}
	
	public String subscribeHome() {
		
		scrollToElement(footerSection);
		return subscribElement.getText();
		
	}
	
	public String subscribeSuccessMsg(String email) {
		
		emailElement.sendKeys(email);
		subscribeBtn.click();
		return subscribeMsg.getText();
		
	}
	
	public CartPage getCartPage() {
		
		cartLink.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public void clickViewProduct() {
		
		driver.findElement(viewProdBy).click();
		
	}
	
	public boolean verifyProductDetails() {
		
		return prodInfo.isDisplayed();		
	}
	
	public void increaseQuantity(String quantity) {
		
		prodInfo.findElement(quantityBy).clear();
		prodInfo.findElement(quantityBy).sendKeys(quantity);
		addToCartBtn.click();
		viewCart.click();
			
	}
	
	public List<String> addProductToCart(int[] prodIds) {
		
		for(int i=0; i<prodIds.length; i++) {
			
			String names = driver.findElement(By.xpath("//a[@data-product-id='" +prodIds[i]+ "']/parent::div[@class='productinfo text-center']//p")).getText();
			productsName.add(names);
			driver.findElement(By.xpath("//a[@data-product-id='"+prodIds[i]+"']")).click();
			continueShoppingBtn.click();
		}
		
		return productsName;
	}
	
	 public boolean getcategoryVisibile() {
		 
		return categoryElement.isDisplayed();
	 }
	 
	 public void clickWomenCategory(String prod) throws InterruptedException {
		 
		 scrollToElement(womenCategoryElement);
		 womenCategoryElement.click();
		 waitForVisibilityOfElement(womenIdBy);
		 List<WebElement> womenCategoryProducts = driver.findElements(By.xpath("//div[@id='Women']//li"));
		 
		 for(int i=0; i<womenCategoryProducts.size(); i++) {
			 
			 String name = womenCategoryProducts.get(i).findElement(By.tagName("a")).getText();
			 System.out.println(name);
			 if(name.equalsIgnoreCase(prod)) {
				 
				 womenCategoryProducts.get(i).findElement(By.linkText(name)).click();
			 }
		 }
		 
	 }
	 
	 public String getRecomItemTitle() {
		 
		 scrollToElement(recomItemsTabElement);
		 return recomItemsTabElement.findElement(titleBy).getText();
	 }

}
