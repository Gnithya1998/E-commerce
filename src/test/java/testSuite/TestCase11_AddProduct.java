package testSuite;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTestPack.BaseTestComponent;
import pageObjectModel_ecom.CartPage;
import pageObjectModel_ecom.HomePage;
import pageObjectModel_ecom.ProductsPage;

public class TestCase11_AddProduct extends BaseTestComponent {

	@Test
	public void TestCase11() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		Boolean homeVisibility = homePage.homePageVisibility();
		Assert.assertTrue(homeVisibility);
		ProductsPage productsPage = homePage.getProductPage();
		productsPage.addFirstProduct();
		productsPage.continueShopping();
		productsPage.addSecondProduct();
		List<String> productsNames = productsPage.productsName();
		CartPage cartPage = new CartPage(driver);
		List<String> cartNames = cartPage.productsInCart();

		for (int i = 0; i < productsNames.size(); i++) {

			if (productsNames.get(i).equalsIgnoreCase(cartNames.get(i))) {

				Assert.assertTrue(true);
			} else {

				Assert.assertTrue(false);
			}

		}

	}
}
