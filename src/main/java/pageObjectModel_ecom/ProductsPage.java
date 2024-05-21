package pageObjectModel_ecom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponentPack.AbstractComponent;

public class ProductsPage extends AbstractComponent{
	
	public WebDriver driver;
	public static List<String> prodNames = new ArrayList<>();
 	
	public ProductsPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
    @FindBy (css = "h2.text-center")
    WebElement allProductTxt;
    
    @FindBy (css = "div.product-image-wrapper")
    List<WebElement> allProducts;
    
    @FindBy (css = "div.product-information")
    WebElement productDetails;
    
    @FindBy (id = "search_product")
    WebElement searchBox;
    
    @FindBy (id = "submit_search")
    WebElement searchIcon;
    
    @FindBy (css = "button.cart")
    WebElement addToCartBtn;
    
    @FindBy(css = "button.btn-block")
    WebElement continueShoppingBtn;
    
    @FindBy(xpath = "//div[@class='icon-box']//following::div[@class='modal-body']//a")
    WebElement viewCart;
    
    @FindBy(css = "a[href='#Women'] span.badge.pull-right")
    WebElement womenCategoryElement;
    
    @FindBy(css = "a[href='#Men'] span.badge.pull-right")
    WebElement menCategoryElement;
    
    
    
    
    By allProdBy = By.cssSelector("h2.text-center");
    By viewProdBy = By.linkText("View Product");
    By addToCartBy = By.cssSelector("a.add-to-cart");
    By addedIconBy = By.cssSelector("div.icon-box");
    By womenIdBy = By.xpath("//div[@id='Women']//li");
    By menIdBy = By.xpath("//div[@id='Men']//li");

    
    public Boolean productPageVisibility() {
    	
    	scrollDown();
    	waitForElementToBePresent(allProdBy);
    	return allProductTxt.isDisplayed();
    }
    
    public int totalProductCount() {
    	
    	
    	int count = 0;
    	count = allProducts.size();
    	return count;
    	
    }
    
    public void firstProduct() {
    	
    	allProducts.get(0).findElement(By.linkText("View Product")).click();
    	
    }
    
    public List<Boolean> productDetailsVisibility() {
    	
    	List<Boolean> detailsBooleans = new ArrayList<>();
    	
    	Boolean nameString = productDetails.findElement(By.tagName("h2")).isDisplayed();
    	detailsBooleans.add(nameString);
    	
    	Boolean categoryString = productDetails.findElement(By.cssSelector("p:first-of-type")).isDisplayed();
    	detailsBooleans.add(categoryString);
    	
    	Boolean priceBoolean = productDetails.findElement(By.cssSelector("span span")).isDisplayed();
    	detailsBooleans.add(priceBoolean);
    	
    	Boolean availabilityBoolean = productDetails.findElement(By.xpath("//b[contains(text(),'Availability')]")).isDisplayed();
    	detailsBooleans.add(availabilityBoolean);
    	
    	Boolean conditionBoolean = productDetails.findElement(By.xpath("//b[contains(text(),'Condition')]")).isDisplayed();
    	detailsBooleans.add(conditionBoolean);
    	
    	Boolean brandBoolean = productDetails.findElement(By.xpath("//b[contains(text(),'Brand')]")).isDisplayed();
    	detailsBooleans.add(brandBoolean);
    	
    	return detailsBooleans;
    }
    
    public void searchProduct(String product) {
    	
    	searchBox.sendKeys(product);
    	searchIcon.click();
    	
    }
    
    public void addFirstProduct() {
    	
    	allProducts.get(0).findElement(viewProdBy).click();
    	String name = driver.findElement(By.cssSelector("div.product-information h2")).getText();
    	prodNames.add(name);
    	addToCartBtn.click();
    	
    }
    
    public void continueShopping() {
		
    	continueShoppingBtn.click();
    	navigateBack();
	}
    
 public void addSecondProduct() {
    	
	 	String name = allProducts.get(1).findElement(By.tagName("p")).getText();
	 	prodNames.add(name);
    	allProducts.get(1).findElement(addToCartBy).click();
    	waitForElementToBePresent(addedIconBy);
    	viewCart.click();    	
    }
 
 public List<String> productsName() {
	 
	 return prodNames;
 }
 
 public String getTitleOfProd() {
	 
	 
	 WebElement prodTitlElement = driver.findElement(By.cssSelector("h2.title"));
	 return prodTitlElement.getText();
 }
 
 public void clickWomenCategory(String prod) {
	 
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
 
 public void clickmenCategory(String prod) {
	 
	 menCategoryElement.click();
	 waitForVisibilityOfElement(menIdBy);
	 List<WebElement> menCategoryProducts = driver.findElements(By.xpath("//div[@id='Men']//li"));
	 
	 for(int j=0; j<menCategoryProducts.size(); j++) {
		 
		 String name = menCategoryProducts.get(j).findElement(By.tagName("a")).getText();
		 System.out.println(name);
		 if(name.equalsIgnoreCase(prod)) {
			 
			 menCategoryProducts.get(j).findElement(By.linkText(name)).click();
		 }
	 }
	 
 }
 
 
 
 

}
