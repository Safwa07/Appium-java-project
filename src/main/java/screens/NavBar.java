package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavBar extends Base {
    //    ##########Define Elements##########
    @AndroidFindBy(accessibility = "Home")
    private WebElement home;
    @AndroidFindBy(accessibility = "Scan")
    private WebElement scan;
    @AndroidFindBy(accessibility = "Account")
    private WebElement account;

    public void clickOnHome() {
        home.click();
    }

    public void clickOnScan() {
        scan.click();
    }

    public void clickOnAccount() {
        account.click();
    }

    public boolean verifyHomeAppear() {
        this.wait.until(ExpectedConditions.visibilityOf(home));
        System.out.println("111111111111111111 " + home.isDisplayed());

        return home.isDisplayed();
    }
    public boolean isHomeDisplayed() {
        return home.isDisplayed();
    }
}
