package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;
import utils.ScrollUntilElementVisible;

public class LoginTest extends Base {
    NotificationsScreen screen;
    OnBoardingScreen onBoarding;
    LoginScreen loginScreen;
    MyAccountScreen account;
    PopupScreens popup;
    NavBar navBar;
    ForgetPasswordScreen forgetPassword;
    CreateAccountScreen createAccount;
    ScrollUntilElementVisible scrollUntilElementVisible;

    @BeforeMethod
    public void reachThisScreen() throws Exception {
        screen = new NotificationsScreen();
        screen.clickOnAllowSendNotification();
        onBoarding = new OnBoardingScreen();
        onBoarding.clickOnLogin();
        popup = new PopupScreens();
        popup.tapOutsidePopup();
    }

    @Test
    public void TC01_SignInwithValidCredentials() {

        loginScreen = new LoginScreen();
        loginScreen.SignInwithValidCredentials("1111186188", "12345678");
        navBar = new NavBar();
        //    Assert that Nav Bar appears
        System.out.println("11111111111111");

        Assert.assertTrue(navBar.verifyHomeAppear());
        System.out.println("222222222222222");
    }

    @Test
    public void TC02_ForgotPassword() {
        loginScreen = new LoginScreen();
        loginScreen.clickForgotPassword();
        forgetPassword = new ForgetPasswordScreen();
        //    Assert that forgot password appears

        Assert.assertTrue(forgetPassword.isSendCodeBtnVisible());
    }

    @Test
    public void TC03_InvalidCredentials() {
        loginScreen = new LoginScreen();
        loginScreen.SignInwithInValidCredentials("123456", "12345678");
        Assert.assertTrue(loginScreen.isErrorMessageDisplayed());
    }


    @Test(enabled = false)
    public void TC04_EmptyCredentials() {
        loginScreen = new LoginScreen();
        loginScreen.signInWithEmptyField();
//      Assert.assertFalse(loginScreen.isLoginBtnClickable());
        navBar = new NavBar();
        //    Assert that Nav Bar not appears
        Assert.assertFalse(navBar.isHomeDisplayed());
    }


    @Test
    public void TC05_clickCreateAccount() {
        loginScreen = new LoginScreen();
        loginScreen.clickCreateAccount();
        createAccount = new CreateAccountScreen();
        //    Assert that create account appears
        Assert.assertTrue(createAccount.verifyCreateAccountText());
    }

    @Test
    public void TC06_loginThenLogout() {
        loginScreen = new LoginScreen();
        loginScreen.SignInwithValidCredentials("1111186188", "12345678");
        //    Assert that logged in successfully
        navBar = new NavBar();
        Assert.assertTrue(navBar.verifyHomeAppear());
        navBar.clickOnAccount();
        account = new MyAccountScreen();
        scrollUntilElementVisible = new ScrollUntilElementVisible();
        scrollUntilElementVisible.scrollUntilElementVisibleFunc(account.logoutBtn, 10);
        account.logout();
        account.clickOnYesLogoutBtn();

        //    Assert that logged out successfully
        Assert.assertTrue(account.isLoginRegisteredBtnVisible());
    }
}
