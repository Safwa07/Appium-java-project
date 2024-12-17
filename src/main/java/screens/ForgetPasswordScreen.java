package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgetPasswordScreen extends Base {
    @AndroidFindBy(accessibility = "Send Code")
    private WebElement sendCodeBtn;

    public boolean isSendCodeBtnVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(sendCodeBtn));
        System.out.println("111111111111111111 " + sendCodeBtn.isDisplayed());
        return sendCodeBtn.isDisplayed();

    }

}
