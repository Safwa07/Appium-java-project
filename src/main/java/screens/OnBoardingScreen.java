package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class OnBoardingScreen extends Base {
    @AndroidFindBy(accessibility = "Skip")
    private WebElement skipBtn;

    @AndroidFindBy(accessibility = "Create Account")
    private WebElement createAccountBtn;
    @AndroidFindBy(accessibility = "Login")
    private WebElement loginBtn;

    @Step("Click on the create account button")
    public void clickonCreateAccount() {
        createAccountBtn.click();
    }

    public void clickOnLogin() {
        loginBtn.click();
    }

    public void clickOnSkip() {
        skipBtn.click();
    }

}
