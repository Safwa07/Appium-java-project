package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import drivers.DriverManager;

import java.time.Duration;

public class LoginScreen extends Base {
    @AndroidFindBy(xpath = "//(//android.view.View[@content-desc=\"Login\"])[1]")
    private WebElement loginText;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index=\"1\"]")
    private WebElement phone;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index=\"0\"]")
    private WebElement password;

    @AndroidFindBy(xpath = "//(//android.view.View[@content-desc=\"Login\"])[2]")
    private WebElement loginBtn;
    @AndroidFindBy(accessibility = "Forgot Password?")
    private WebElement forgotPasswordBtn;
    @AndroidFindBy(accessibility = "Don’t have an account?\n" +
            "Create Account")
    private WebElement createAccountBtn;
    @AndroidFindBy(accessibility = "Phone number or password is incorrect, please try again with correct credentials")
    private WebElement errorMessage;

    public void SignInwithValidCredentials(String phone, String password) {
        this.phone.click();
        this.phone.sendKeys(phone);
        this.password.click();
        this.password.sendKeys(password);
        driver.hideKeyboard();

        this.loginBtn.click();
    }

    public void SignInwithInValidCredentials(String phone, String password) {
        this.phone.click();
        this.phone.sendKeys(phone);
        this.password.click();
        this.password.sendKeys(password);
        driver.hideKeyboard();

        this.loginBtn.click();
    }

    public void clickForgotPassword() {
        this.forgotPasswordBtn.click();
    }

    public void clickCreateAccount() {
        this.createAccountBtn.click();
    }

    public boolean isErrorMessageDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(errorMessage));
        System.out.println("111111111111111111 " + errorMessage.isDisplayed());

        return errorMessage.isDisplayed();
    }

    public boolean isLoginBtnClickable() {
        this.wait.until(ExpectedConditions.visibilityOf(loginBtn));

        return loginBtn.isEnabled();
    }

    public void signInWithEmptyField() {
        this.phone.sendKeys("");
        this.password.sendKeys("");
        this.loginBtn.click();
    }

    public boolean verifyloginBtnDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(loginBtn));
        System.out.println("111111111111111111 " + loginBtn.isDisplayed());
        return loginBtn.isDisplayed();

    }
}


//
//    @Step("Logging in with username: {username} and password: {password}")
