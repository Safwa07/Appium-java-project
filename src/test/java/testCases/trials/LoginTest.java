package testCases.trials;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import tests.BaseTestForNativeAppViaPackage;
import utils.ScreenshotHelper;

public class LoginTest extends BaseTestForNativeAppViaPackage {
    ScreenshotHelper screenshotHelper = new ScreenshotHelper();

    @DisplayName("Verify Login Functionality")
    @Test (priority = 1)
    public void TC01_ValidLogin() {
        Allure.step("Launching the app and logging in");
//        actions.login("testUser", "testPass");
        screenshotHelper.takeScreenshot(driver);

//        WebElement dashboard = driver.findElementById("dashboard");
        Allure.step("Verifying dashboard visibility");
//        Assertions.assertTrue(dashboard.isDisplayed());


        // Write your test case here
    }

    @Test(priority = 2)
    public void TC02_LoginWithInvalidEmail() {
        // Write your test case here
    }

    @Test
    public void TC03_LoginWithInvalidPassword() {
        // Write your test case here
    }

    @Test
    public void TC04_LoginWithEmptyEmailAndPassword() {
        // Write your test case here
    }


}
//
//ntg
//3agoza
//2-3days
//senior qa
//