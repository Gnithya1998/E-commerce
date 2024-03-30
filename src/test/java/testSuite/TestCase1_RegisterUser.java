package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase1_RegisterUser extends BaseTestComponent{
	
	@Test
	public void TestCase1() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		boolean homeDisplay = homePage.homePageVisibility();
		Assert.assertTrue(homeDisplay);
		RegistrationPage registrationPage = homePage.signupPage();
		String newSignUpText = registrationPage.newUserSignUp();
		Assert.assertEquals(newSignUpText, "New User Signup!");
		registrationPage.signUp();
		
		
	}

}
