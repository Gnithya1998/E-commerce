package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.ProductsPage;

public class TestCase17_ViewCategoryProds extends BaseTestComponent{
	
	String prodString = "SAREE";
	String prodString2 = "JEANS";
	
	@Test
	public void TestCase17() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean verifyCategoryVisibility = homePage.getcategoryVisibile();
		Assert.assertTrue(verifyCategoryVisibility);
		
		homePage.clickWomenCategory(prodString);
		ProductsPage productsPage = new ProductsPage(driver);
		String proTtile = productsPage.getTitleOfProd();
		Assert.assertEquals(proTtile, "WOMEN - " + prodString+ " PRODUCTS");
		
		productsPage.clickmenCategory(prodString2);
		String proTtile2 = productsPage.getTitleOfProd();
		Assert.assertEquals(proTtile2, "MEN - " + prodString2+ " PRODUCTS");
		
	}

}
