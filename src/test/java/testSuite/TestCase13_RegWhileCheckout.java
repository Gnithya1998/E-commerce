package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.CartPage;
import pageObjectModel_ecom.CheckoutPage;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.PaymentPage;
import pageObjectModel_ecom.RegistrationPage;

public class TestCase13_RegWhileCheckout extends BaseTestComponent {

	String name = "Bashaa";
	String email = "bashaa9922@abc.com";
	String password = "Admin@123";
	String lastName = "Manick";
	String address = "IIT Madras";
	String country = "India";
	String state = "Chennai";
	String city = "Chennai";
	String zipCode = "600 036";
	String mobileNum = "1234567890";
	String discription = "Added products are visible in the checkout page";
	String number = "1234 5678 9012 3456";
	String cvv = "123";
	String month = "11";
	String year = "2099";
	int[] ids = {2,7,8,10,6};

	@Test
	public void TestCase13() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);

		homePage.addProductToCart(ids);
		CartPage cartPage = homePage.getCartPage();
		String cartPageVisibility = cartPage.cartUrl();
		Assert.assertEquals(cartPageVisibility, "https://automationexercise.com/view_cart");

		cartPage.checkOutBtn();
		RegistrationPage registrationPage = cartPage.getRegisterPage();
		registrationPage.signUp(name, email);
		boolean accInfoTxtMsg = registrationPage.accInfoMsg();
		Assert.assertTrue(accInfoTxtMsg);

		registrationPage.accountInformationForm(name, email, password);
		registrationPage.addressInformationForm(name, lastName, address, country, state, city, zipCode, mobileNum);
		registrationPage.homeNavigation();
		String userNameString = homePage.usernameCheck();
		Assert.assertEquals("Logged in as " + userNameString, "Logged in as " + name);

		homePage.getCartPage();
		CheckoutPage checkoutPage = cartPage.checkOutBtn();
		Boolean addresVisibility = checkoutPage.addressDisplay();
		Assert.assertTrue(addresVisibility);

		Boolean cartVisibility = checkoutPage.cartDiaplayed();
		Assert.assertTrue(cartVisibility);

		PaymentPage payePaymentPage = checkoutPage.ClickPlaceOrder(discription);
		payePaymentPage.cardDetails(name, number, cvv, month, year);
		String successMsg = payePaymentPage.orderSuccessMsg();
		Assert.assertEquals(successMsg, "Congratulations! Your order has been confirmed!");

		boolean deleteMsg = homePage.deleteAcc();
		Assert.assertTrue(deleteMsg);
		homePage.cntBtnClick();

	}

}
