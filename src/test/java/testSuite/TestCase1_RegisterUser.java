package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase1_RegisterUser extends BaseTestComponent {
	
	String name = "Bashaa";
	String email = "bashaa456@gmail.com";
	String password = "Admin@123";

	@Test
	public void TestCase1() {

		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		boolean homeDisplay = homePage.homePageVisibility();
		Assert.assertTrue(homeDisplay);
		RegistrationPage registrationPage = homePage.signupPage();
		String newSignUpText = registrationPage.newUserSignUp();
		Assert.assertEquals(newSignUpText, "New User Signup!");
		registrationPage.signUp(name, email);
		boolean accInfoTxtMsg = registrationPage.accInfoMsg();
		Assert.assertTrue(accInfoTxtMsg);
		registrationPage.accountInformationForm(name, email, password);
		boolean addressInfoTxtMsg = registrationPage.addressInfoMsg();
		Assert.assertTrue(addressInfoTxtMsg);
		registrationPage.addressInformationForm(name);
		boolean accCreatedTxtMsg = registrationPage.accCreatedMsg();
		Assert.assertTrue(accCreatedTxtMsg);	
		registrationPage.homeNavigation();
		String userString = homePage.usernameCheck();
		Assert.assertEquals("Logged in as " + userString, "Logged in as " + name);
		boolean deleteMsg = homePage.deleteAcc();
		Assert.assertTrue(deleteMsg);
		homePage.cntBtnClick();
		

	}

}
