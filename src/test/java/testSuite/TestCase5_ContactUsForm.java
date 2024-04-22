package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.ContactUsPage;
import pageObjectModel_ecom.HomePage;


public class TestCase5_ContactUsForm extends BaseTestComponent{
	
	public String name = "Nikki";
	public String email = "nikki123123@gmailcom";
	public String subject = "Product picture is not displayed";
	public String message = "Product picture is not displayed in the home page section for adding it to the product cart.";
	
	
	@Test
	public void TestCase5() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		ContactUsPage contactUsPage = homePage.contactUs();
		boolean getInTouchVisibility = contactUsPage.getInTouchDisplay();
		Assert.assertTrue(getInTouchVisibility);
		
		
	}
}
