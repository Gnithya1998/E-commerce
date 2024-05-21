package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.CartPage;

public class TestCase12_ProductQuantity extends BaseTestComponent{
	
	String quantityString = "4";
	
	@Test
	public void TestCase12() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		homePage.clickViewProduct();
		Boolean productDetails =  homePage.verifyProductDetails();
		Assert.assertTrue(productDetails);
		homePage.increaseQuantity(quantityString);
		CartPage cartPage = homePage.getCartPage();
		String quantityValue = cartPage.checkProdQuantity();
		Assert.assertEquals(quantityValue, quantityString);
		
		
	}

}
