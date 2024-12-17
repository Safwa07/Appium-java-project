package testCases;

import base.Base;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;
import utils.ScrollUntilElementVisible;
import utils.TestUtils;

public class AccountFunctionTest extends Base {

    NotificationsScreen screen;
    OnBoardingScreen onBoarding;
    PopupScreens popup;
    MyAccountScreen myAccount;
    ScrollUntilElementVisible scroll;
    TestUtils testUtils;

    NavBar navBar;

    @BeforeMethod
    public void reachPage() {
        screen = new NotificationsScreen();
        screen.clickOnAllowSendNotification();
        onBoarding = new OnBoardingScreen();
        onBoarding.clickOnSkip();
        popup = new PopupScreens();
        popup.tapOutsidePopup();
        navBar = new NavBar();
        navBar.clickOnAccount();
    }

    @Test
    public void TC01_ChangeLanguageToArabic() {
        myAccount = new MyAccountScreen();
        myAccount.clickOnSetting();
        myAccount.changeLanguageToArabic();

    }

    @Test
    public void TC02_ReadFAQS() throws InterruptedException {
        myAccount = new MyAccountScreen();
        myAccount.clickOnFAQs();
        scroll = new ScrollUntilElementVisible();
        scroll.scrollToEnd();
        Thread.sleep(3000);

    }

    @Test
    public void TC03_OpenTermsAndConditions() throws InterruptedException {
        myAccount = new MyAccountScreen();
        myAccount.clickOnTermsAndConditionsBtn();
        scroll = new ScrollUntilElementVisible();
        scroll.scrollToEnd();
        Thread.sleep(3000);
    }
}