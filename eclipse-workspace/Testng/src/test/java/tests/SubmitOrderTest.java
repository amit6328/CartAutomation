package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class SubmitOrderTest extends BaseTest {

    @Test
    public void submitOrderTest() {

        String productName = "ZARA COAT 3";

        LandingPage landingPage = new LandingPage(driver);
        ProductCatalogue productCatalogue =
                landingPage.loginApplication("test@mailiantor.com", "Test@1234");

        productCatalogue.addProductToCart(productName);

        CartPage cartPage = productCatalogue.goToCartPage();
        Assert.assertTrue(cartPage.verifyProductDisplay(productName));

        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        Assert.assertEquals(
                confirmationPage.getConfirmationMessage(),
                "THANKYOU FOR THE ORDER."
        );
    }
}
