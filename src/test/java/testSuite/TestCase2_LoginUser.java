package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase2_LoginUser extends BaseTestComponent{
	
	String name = "nikki";
	String email = "nikki123123@gamil.com";
	String password = "Bashaa@1998";
	
	@Test
	public void TestCase2() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		boolean homePageDisplay = homePage.homePageVisibility();
		Assert.assertTrue(homePageDisplay);
		RegistrationPage resiRegistrationPage = homePage.signupPage();
		String loginMsg = resiRegistrationPage.userLogin();
		Assert.assertEquals(loginMsg, "Login to your account");
		resiRegistrationPage.Login(email, password);
		String userName = homePage.usernameCheck();
		Assert.assertEquals("Logged in as " + userName, "Logged in as " + name);
		homePage.logoutAcc();
		
	}
	

}
