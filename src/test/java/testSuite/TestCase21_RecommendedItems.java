package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;

public class TestCase21_RecommendedItems extends BaseTestComponent{

	@Test
	public void TestCase21() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Assert.assertEquals(homePage.getRecomItemTitle(), "RECOMMENDED ITEMS");
		
		
		
	}
}
