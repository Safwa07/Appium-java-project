package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;

import java.time.Duration;

public class CreateAccountScreen extends Base {
    //    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.widget.EditText")
    @AndroidFindBy(xpath = "(//android.widget.EditText[@index='0'])[1]")
    private WebElement name;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index=\"1\"]")
    private WebElement phone;
    //    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[10]/android.widget.EditText")
    @AndroidFindBy(xpath = "(//android.widget.EditText[@index='0'])[2]")
    private WebElement password;
    @AndroidFindBy(xpath = "//android.view.View[@index=\"12\"]")
    private WebElement chargingProtocol;

    @AndroidFindBy(accessibility = "CCS1")
    private WebElement ccs1;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Continue\"]")
    private WebElement continueBtn;
    @AndroidFindBy(accessibility = "Already have an account?\n" +
            "Login")
    private WebElement loginBtn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Create Account\"]")
    private WebElement verifyCreateAccountText;
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    TestUtils utils;

    public void createValidAccount(String name, String phone, String password) {
        this.name.click();
        this.name.sendKeys(name);
        this.phone.click();
        this.phone.sendKeys(phone);
        this.password.click();


        this.password.sendKeys(password);
        driver.hideKeyboard();

        chargingProtocol.click();
        ccs1.click();
        continueBtn.click();
    }

    public String getContinueBtnColor() {
        utils = new TestUtils();
        return utils.getButtonColor(continueBtn);

    }

    public boolean verifyCreateAccountText() {
        this.wait.until(ExpectedConditions.visibilityOf(verifyCreateAccountText));
        System.out.println("111111111111111111 " + verifyCreateAccountText.isDisplayed());
        return verifyCreateAccountText.isDisplayed();
    }

    public void createValidAccountWithoutChargeProtocol(String name, String phone, String password) {
        this.name.click();
        this.name.sendKeys(name);
        this.phone.click();
        this.phone.sendKeys(phone);
        this.password.click();
        this.password.sendKeys(password);
        driver.hideKeyboard();
        continueBtn.click();

    }

    public void VerifyCountinueBtnNotClickable() {
        utils = new TestUtils();
        utils.verifyButtonNotClickable(continueBtn);
    }

    public void login() {
        loginBtn.click();
    }
}
