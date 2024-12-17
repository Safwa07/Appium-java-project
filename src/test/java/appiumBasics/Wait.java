package appiumBasics;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.BaseTestForNativeAppViaPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Wait extends BaseTestForNativeAppViaPackage {

    @Test
    public void ImplictWait() {
        //wait for all elements within 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //        driver.findElement(By.id());
        //        driver.findElement(By.id());
    }

    @Test
    public void ExplicitWait() {
        //element with condition
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf((WebElement) By.id("test")));


    }

    @Test
    public void FluentWait() {
        FluentWait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NoSuchFieldException.class);

        wait.until(ExpectedConditions.visibilityOf((WebElement) By.id("test")));
    }

    @Test
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(3000);
    }

}
