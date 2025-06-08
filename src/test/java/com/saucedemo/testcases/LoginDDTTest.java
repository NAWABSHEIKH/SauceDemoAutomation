package com.saucedemo.testcases;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.tests.BaseTest;
import com.saucedemo.utils.TestDataUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginDDTTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestDataUtil.class)
    public void testLoginWithMultipleCredentials(String username, String password, String expectedResult) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        if (expectedResult.equalsIgnoreCase("pass")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Valid login failed for user: " + username);
        } else {
            // Check if error message is displayed for invalid login
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Invalid login passed for user: " + username);
        }
    }
}
