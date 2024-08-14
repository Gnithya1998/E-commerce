package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.ProductsPage;

public class TestCase18_ViewBrandProds extends BaseTestComponent{

	String brand = "Mast & Harbour";
	String brand2 = "Polo";
	
	@Test
	public void TestCase18() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homePageVisible = homePage.homePageVisibility();
		Assert.assertTrue(homePageVisible);
		
		ProductsPage productsPage = homePage.getProductPage();
		Assert.assertTrue(productsPage.verifyBrandsVisibility());
		
		productsPage.selectBrands(brand);
		Assert.assertEquals(productsPage.brandTitle(), "BRAND - MAST & HARBOUR PRODUCTS");
		
		productsPage.selectBrands(brand2);
		Assert.assertEquals(productsPage.brandTitle(), "BRAND - POLO PRODUCTS");
	}
}
