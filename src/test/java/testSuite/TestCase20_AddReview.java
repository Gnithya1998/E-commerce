package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.ProductsPage;

public class TestCase20_AddReview extends BaseTestComponent{
	
	public String review = "Product quality is not good";
	String email = "nikki123123@gamil.com";
	String name = "Nikki";
	
	@Test
	public void TestCase20() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		ProductsPage productsPage = homePage.getProductPage();
		Thread.sleep(4000);
		Assert.assertEquals(productsPage.brandTitle(), "ALL PRODUCTS");
		
		productsPage.clickViewProduct();
		Assert.assertEquals(productsPage.verifyReviewTxt(), "WRITE YOUR REVIEW");
		
		productsPage.writeReview(name, email, review);
		Assert.assertEquals(productsPage.getReviewSuccessMsg(), "Thank you for your review.");
		
	}

}
