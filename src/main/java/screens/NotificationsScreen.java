package screens;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NotificationsScreen extends Base {

 //    ##########Define Elements##########

//    @AndroidFindBy(id = "com.example:id/username")
//    @AndroidFindBy(id = "com.example:id/username")
//    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Only this time\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Only this time\"]")
    private WebElement onlyThisTimeBtn;

    @AndroidFindBy(xpath = "//*[@text=\"Allow\"]")
    private WebElement allowSendNotificationBtn;
    @AndroidFindBy(xpath = "//*[@text=\"While using the app\"]")
    private WebElement allowWhileUsingLocationBtn;

    //    ##########Define Actions##########

    public void clickOnAccessLocationPopUp() throws InterruptedException {
        System.out.println("start click on access location");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(onlyThisTimeBtn));

        this.onlyThisTimeBtn.click();
        Thread.sleep(3000);
    }

    public void clickOnAllowSendNotification() {
        allowSendNotificationBtn.click();
    }
    public void clickOnAllowWhileUsingLocation() {
        allowWhileUsingLocationBtn.click();
    }

}
