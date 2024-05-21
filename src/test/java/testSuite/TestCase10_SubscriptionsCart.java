package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.CartPage;
import pageObjectModel_ecom.HomePage;

public class TestCase10_SubscriptionsCart extends BaseTestComponent{
	
	public String emailString = "Nikki123324@gmail.com";

	@Test
	public void TestCase10() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		CartPage cartPage = homePage.getCartPage();
		String subHome = cartPage.subscribeCart();
		Assert.assertEquals(subHome, "SUBSCRIPTION");
		String successMsg = cartPage.subscribeSuccessMsg(emailString);
		Assert.assertEquals(successMsg, "You have been successfully subscribed!");
	}
}
