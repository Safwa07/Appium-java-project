package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

public class OTPScreen extends Base {

    @AndroidFindBy(accessibility = "OTP Verification")
    private WebElement otp;

    TestUtils utils;


    public boolean VerifyPhoneNumber(String phoneNumber) {

        utils = new TestUtils();
//        utils.isTextPresent("+20" + phoneNumber);
        return utils.isTextPresent("+20" + phoneNumber);

    }

    public boolean verifyOtpScreen() {
        utils = new TestUtils();
        return utils.waitForElementToAppear(otp);
    }

    public void enterOTP(String otp) {
        this.otp.sendKeys(otp);
    }

}
