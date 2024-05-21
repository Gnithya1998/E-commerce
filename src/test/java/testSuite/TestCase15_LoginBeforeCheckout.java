package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.CartPage;
import pageObjectModel_ecom.CheckoutPage;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.PaymentPage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase15_LoginBeforeCheckout extends BaseTestComponent{
	
	String name = "nikki";
	String email = "nikki123123@gamil.com";
	String password = "Bashaa@1998";
	String discription = "Added products are visible in the checkout page";
	String number = "1234 5678 9012 3456";
	String cvv = "123";
	String month = "11";
	String year = "2099";
	int[] ids = {2,7,8,10,6};
	
	@Test
	public void TestCase15() {
		
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		
		RegistrationPage resiRegistrationPage = homePage.signupPage();
		String loginMsg = resiRegistrationPage.userLogin();
		Assert.assertEquals(loginMsg, "Login to your account");
		resiRegistrationPage.Login(email, password);
		String userName = homePage.usernameCheck();
		Assert.assertEquals("Logged in as " + userName, "Logged in as " + name);
		
		homePage.addProductToCart(ids);
		CartPage cartPage = homePage.getCartPage();
		String cartPageVisibility = cartPage.cartUrl();
		Assert.assertEquals(cartPageVisibility, "https://automationexercise.com/view_cart");
		
		CheckoutPage checkoutPage = cartPage.checkOutBtn();
		Boolean addresVisibility = checkoutPage.addressDisplay();
		Assert.assertTrue(addresVisibility);

		Boolean cartVisibility = checkoutPage.cartDiaplayed();
		Assert.assertTrue(cartVisibility);

		PaymentPage payePaymentPage = checkoutPage.ClickPlaceOrder(discription);
		payePaymentPage.cardDetails(name, number, cvv, month, year);
		String successMsg = payePaymentPage.orderSuccessMsg();
		Assert.assertEquals(successMsg, "Congratulations! Your order has been confirmed!");
	}

}
