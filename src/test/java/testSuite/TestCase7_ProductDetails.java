package testSuite;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.ProductsPage;

public class TestCase7_ProductDetails extends BaseTestComponent{
	
	@Test
	public void TestCase7() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		ProductsPage productsPage = homePage.getProductPage();
		Boolean allProductTxt = productsPage.productPageVisibility();
		Assert.assertTrue(allProductTxt);
//		int count = productsPage.totalProductCount();
//		Assert.assertEquals(count, 34);
		productsPage.firstProduct();
		List<Boolean> detailsBooleans = productsPage.productDetailsVisibility();
		for(Boolean e: detailsBooleans) {
			
			Assert.assertTrue(e);
		}
		
		
	}

}
