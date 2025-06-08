package com.saucedemo.utils;

import org.testng.annotations.DataProvider;

public class TestDataUtil {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", "pass"},
            {"locked_out_user", "secret_sauce", "fail"},
            {"invalid_user", "wrong_password", "fail"}
        };
    }
}
