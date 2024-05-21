package testSuite;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.CartPage;
import pageObjectModel_ecom.HomePage;

public class TestCase16_RemoveProCart extends BaseTestComponent{
	
	int[] ids = {2,7,8,1,6};
	int[] removeIds = {2, 8};

	@Test
	public void TestCase16() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		
		List<String> productNames = homePage.addProductToCart(ids);
		CartPage cartPage = homePage.getCartPage();
		String cartPageVisibility = cartPage.cartUrl();
		Assert.assertEquals(cartPageVisibility, "https://automationexercise.com/view_cart");
		
		List<String> productsInCart = cartPage.productsInCart();
		
		for(int i=0; i<productNames.size(); i++) {
			
			if(productNames.get(i).equalsIgnoreCase(productsInCart.get(i))) {
				
				Assert.assertTrue(true);
			}else {
				
				Assert.assertTrue(false);
			}
		}
		
		cartPage.removeItems(removeIds);
		List<String> prodNamesAfterRemovingInCart = cartPage.productsInCart();
		
		for(int i=0; i<productsInCart.size(); i++) {
			
			String firstString = productsInCart.get(i);
			for(int j=0; j<prodNamesAfterRemovingInCart.size(); j++) {
				
				String secondString = prodNamesAfterRemovingInCart.get(j);
				
				if(firstString.equalsIgnoreCase(secondString)) {
					
					System.out.println("Product available in the cart");
				}else {
					
					System.out.println(secondString);
				}
			}
		}
		
		
		
		
	}
}
