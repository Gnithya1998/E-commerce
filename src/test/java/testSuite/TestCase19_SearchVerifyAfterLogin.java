package testSuite;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.CartPage;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.ProductsPage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase19_SearchVerifyAfterLogin extends BaseTestComponent{
	
	public String prodString = "dress";
	String email = "nikki123123@gamil.com";
	String password = "Bashaa@1998";

	@Test
	public void TestCase19() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		
		ProductsPage productsPage = homePage.getProductPage();
		Boolean allProductTxt = productsPage.productPageVisibility();
		Assert.assertTrue(allProductTxt);
		
		productsPage.searchProduct(prodString);
		Assert.assertEquals(productsPage.brandTitle(), "SEARCHED PRODUCTS");
		
		List<String> prodsName = productsPage.productsName();
		
		productsPage.prodsAfterSearch();
		CartPage cartPage = productsPage.getCartPage();
		
		RegistrationPage registrationPage = homePage.signupPage();
		registrationPage.Login(email, password);
		
		homePage.getCartPage();
		List<String> prodsNameInCart = cartPage.productsInCart();
		
		for(int i=0; i<prodsName.size(); i++) {
			
			String pro1 = prodsName.get(i);
			System.out.println(pro1);
			String pro2 = prodsNameInCart.get(i);
			System.out.println(pro2);
			
			if(pro1.equalsIgnoreCase(pro2)) {
				
				Assert.assertTrue(false);
			}else {
				
				Assert.assertTrue(true);
			}
		}
		
		
		
		
		
	}

}
