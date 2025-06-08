package com.saucedemo.listeners;

import com.saucedemo.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        System.out.println("❌ Test failed: " + testName);

        // ✅ Get driver from context
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");

        if (driver != null) {
            ScreenshotUtil.takeScreenshot(driver, testName);
        } else {
            System.out.println("❌ WebDriver is null. Cannot take screenshot.");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test passed: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("▶️ Test started: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⏭️ Test skipped: " + result.getName());
    }
}
