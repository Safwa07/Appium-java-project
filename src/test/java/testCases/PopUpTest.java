package testCases;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.CreateAccountScreen;
import screens.NotificationsScreen;
import screens.OnBoardingScreen;
import screens.PopupScreens;

public class PopUpTest extends Base {

    NotificationsScreen screen;
    OnBoardingScreen onBoarding;
    CreateAccountScreen createAccount;
    PopupScreens popup;

    @Test
    @Feature("PopUp Handling")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify TC001_allowNofi successfully.")
    public void TC001_allowNofi() throws InterruptedException {
        screen = new NotificationsScreen();
        screen.clickOnAllowSendNotification();
//        screen.clickOnAllowSendNotification();

    }

    @Test
    @Feature("PopUp Handling")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify TC002_clickOnCreateAccount successfully.")
    public void TC002_clickOnCreateAccount() throws InterruptedException {
        screen = new NotificationsScreen();
        screen.clickOnAllowSendNotification();
        onBoarding = new OnBoardingScreen();
        onBoarding.clickonCreateAccount();
        Thread.sleep(3000);
        popup = new PopupScreens();
        popup.tapOutsidePopup();
        Thread.sleep(3000);
        createAccount = new CreateAccountScreen();
        Assert.assertTrue(createAccount.verifyCreateAccountText());
        System.out.println("doneeeeee");
    }

}