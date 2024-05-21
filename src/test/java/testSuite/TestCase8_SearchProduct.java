package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.ProductsPage;

public class TestCase8_SearchProduct extends BaseTestComponent{
	
	public String prodString = "tops";

	@Test
	public void TestCase8() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		ProductsPage productsPage = homePage.getProductPage();
		Boolean allProductTxt = productsPage.productPageVisibility();
		Assert.assertTrue(allProductTxt);
		productsPage.searchProduct(prodString);
		Assert.assertEquals(productsPage.totalProductCount(), 13);
		
	}
}
