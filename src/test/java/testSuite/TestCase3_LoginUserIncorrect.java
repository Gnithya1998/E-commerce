package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase3_LoginUserIncorrect extends BaseTestComponent{
	
	String username = "ikki123123@gamil.com";
	String password = "Bashaa1998"; 
	
	@Test
	public void TestCase3() {
	
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		boolean homePageDisplay = homePage.homePageVisibility();
		Assert.assertTrue(homePageDisplay);
		RegistrationPage registrationPage = homePage.signupPage();
		String userLoginTxt = registrationPage.userLogin();
		Assert.assertEquals(userLoginTxt, "Login to your account");
		registrationPage.Login(username, password);
		String loginIncorrectMsg = registrationPage.errorMsgElement();
		Assert.assertEquals(loginIncorrectMsg, "Your email or password is incorrect!");

	}

}
