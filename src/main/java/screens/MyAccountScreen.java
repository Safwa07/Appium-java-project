package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScrollUntilElementVisible;

import java.time.Duration;
import java.util.List;

public class MyAccountScreen extends Base {
    @AndroidFindBy(accessibility = "Log Out")
    public WebElement logoutBtn;

    @AndroidFindBy(accessibility = "Login/Register")
    private WebElement loginRegisterBtn;
    @AndroidFindBy(accessibility = "Log Out")
    private WebElement yesLogout;
    @AndroidFindBy(accessibility = "Settings")
    private WebElement settingBtn;
    @AndroidFindBy(accessibility = "FAQs")
    private WebElement faqsBtn;

    @AndroidFindBy(accessibility = "Language\n" +
            "English")
    private WebElement language;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"العربية\"]/android.view.View")
    private WebElement arabicLanguage;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"English\"]/android.view.View")
    private WebElement englishLanguage;

    @AndroidFindBy(accessibility = "Save Changes")
    private WebElement saveChangesBtn;
    @AndroidFindBy(accessibility = "Terms & Conditions")
    private WebElement termsAndConditionsBtn;

    ScrollUntilElementVisible scroll;

    public void logout() {
        this.wait.until(ExpectedConditions.visibilityOf(logoutBtn));

        logoutBtn.click();
    }

    public void clickOnSetting() {
        settingBtn.click();
    }

    public void changeLanguageToArabic() {
        language.click();
        arabicLanguage.click();
        saveChangesBtn.click();
    }

    public void clickOnTermsAndConditionsBtn() {
        scroll = new ScrollUntilElementVisible();
        scroll.scrollUntilElementVisibleFunc(termsAndConditionsBtn,10);
        termsAndConditionsBtn.click();
    }

    public void clickOnFAQs() {
        faqsBtn.click();
    }

    public void clickOnLoginRegister() {
        loginRegisterBtn.click();
    }

    public void scrollToLogout() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        // Swipe from (100, 500) to (100, 100)
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 100, 500));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 100, 100));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    public boolean isLoginRegisteredBtnVisible() {
        this.wait.until(ExpectedConditions.visibilityOf(loginRegisterBtn));
        System.out.println("111111111111111111 " + loginRegisterBtn.isDisplayed());
        return loginRegisterBtn.isDisplayed();
    }

    public void clickOnYesLogoutBtn() {
        this.wait.until(ExpectedConditions.visibilityOf(yesLogout));
        yesLogout.click();
    }
}
