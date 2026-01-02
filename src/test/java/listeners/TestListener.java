package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("❌ Test Failed: " + result.getName());

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        ScreenshotUtil.captureScreenshot(driver, result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test Passed: " + result.getName());
    }
}
