package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;

public class TestCase9_SubscriptionHome extends BaseTestComponent{
	
	public String emailString = "Nikki123@gmail.com";

	@Test
	public void TestCase9() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		String subHome = homePage.subscribeHome();
		Assert.assertEquals(subHome, "SUBSCRIPTION");
		String successMsg = homePage.subscribeSuccessMsg(emailString);
		Assert.assertEquals(successMsg, "You have been successfully subscribed!");
	}
}
