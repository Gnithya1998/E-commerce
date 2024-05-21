package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.TestCasePage;

public class TestCase6_TestCasePage extends BaseTestComponent{
	
	@Test
	public void TestCase6() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		TestCasePage testCasePage = homePage.TestCases();
		Boolean testCaseVisibility = testCasePage.testCasePageVisibility();
		Assert.assertTrue(testCaseVisibility);
	}

}
