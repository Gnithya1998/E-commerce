package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase4_ExistingEmail extends BaseTestComponent {
	
	String name = "Nikki";
	String email = "nikki123123@gamil.com";

	@Test
	public void TestCase4() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		boolean homePageVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homePageVisibility);
		RegistrationPage registrationPage = homePage.signupPage();
		String newUserSignUpTxt = registrationPage.newUserSignUp(); 
		Assert.assertEquals(newUserSignUpTxt, "New User Signup!");
		registrationPage.signUp(name, email);
		String errorMsg = registrationPage.errorMsgElement();
		Assert.assertEquals(errorMsg, "Email Address already exist!");
		
	}
}
