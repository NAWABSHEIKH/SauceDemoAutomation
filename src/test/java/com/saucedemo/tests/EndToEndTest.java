package com.saucedemo.tests;

import com.saucedemo.listeners.TestListener;
import com.saucedemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class EndToEndTest extends BaseTest {

    @Test
    public void testSauceDemoOrderFlow() {
        System.out.println("Starting login...");

        LoginPage loginPage = new LoginPage(driver);
       loginPage.login("standard_user", "wrong_password");
      // loginPage.login("standard_user", "secret_sauce");

        System.out.println("Login successful. Navigating to products...");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBackpackToCart();
        productsPage.clickCartIcon();

        System.out.println("Cart clicked. Proceeding to checkout...");

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        System.out.println("Filling user details...");

        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterUserDetails("John", "Doe", "12345");

        System.out.println("User details submitted. Finishing order...");

        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualMessage = checkoutCompletePage.getSuccessMessage();
        System.out.println("Actual Message: " + actualMessage);

        Assert.assertEquals(actualMessage, "Thank you for your order!", "Order success message mismatch!");
    }
}
