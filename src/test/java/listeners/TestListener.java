package listeners;

import base.Base;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class TestListener implements ITestListener {
    private static final Logger logger = Logger.getLogger(TestListener.class.getName());

//    public TestListener() {
//        System.setProperty("allure.results.directory", "target/allure-results");
//    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        if (result.getThrowable() != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            result.getThrowable().printStackTrace(printWriter);
            System.out.println(stringWriter.toString());
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Starting Execution of Test Suite: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Finished Execution of Test Suite: " + context.getName());
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] captureScreenshot(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((Base) testClass).getDriver();
        if (driver != null) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }

}
