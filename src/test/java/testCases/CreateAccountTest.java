package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;
import utils.TestUtils;

public class CreateAccountTest extends Base {

    NotificationsScreen screen;
    OnBoardingScreen onBoarding;
    CreateAccountScreen createAccount;
    PopupScreens popup;
    LoginScreen login;
    OTPScreen otp;
    TestUtils util;

    @BeforeMethod
    public void reachThisScreen() throws Exception {
        screen = new NotificationsScreen();
        screen.clickOnAllowSendNotification();
        onBoarding = new OnBoardingScreen();
        onBoarding.clickonCreateAccount();
        popup = new PopupScreens();
        popup.tapOutsidePopup();

    }

    @Test
    public void TC01_SignUpWithValidInformation() {

        createAccount = new CreateAccountScreen();
        createAccount.createValidAccount("John Doe", "1234567890", "password123");
        //    Assert that the otp screen appears
        otp = new OTPScreen();
        Assert.assertTrue(otp.verifyOtpScreen());
        //        Assert that same phone will receive otp message
        boolean otpResult = otp.VerifyPhoneNumber("1234567890");
        Assert.assertTrue(otpResult);
    }

    //    @Test(enabled = false)
    @Test
    public void TC02_SignUpWithoutName() {
        createAccount = new CreateAccountScreen();
        String btnColorValue = createAccount.getContinueBtnColor();

        createAccount.createValidAccount("", "1234567890", "password123");
//        Assert that continue btn not clickable
//        createAccount.VerifyCountinueBtnNotClickable();
        Assert.assertEquals(createAccount.getContinueBtnColor(), btnColorValue);

    }

    @Test
    public void TC03_PressOnLogin() {
        createAccount = new CreateAccountScreen();
        createAccount.login();
        login = new LoginScreen();
        //Assert that login screen appears
        Assert.assertTrue(login.verifyloginBtnDisplayed());
    }
}
