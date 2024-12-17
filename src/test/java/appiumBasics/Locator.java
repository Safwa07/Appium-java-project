package appiumBasics;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseTestForNativeAppViaPackage;

public class Locator extends BaseTestForNativeAppViaPackage {

    // Locators for elements in the app
@Test
    public void testLocators() throws InterruptedException {

//    driver.findElement(By.id("com.google.android.deskclock:id/fab")).click();
    driver.findElement(By.id("com.google.android.deskclock:id/navigation_bar_item_small_label_view")).click(); //Alarm
    driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Timer']")).click(); //Timer
    driver.findElement(By.xpath("(android.widget.TextView)[2]]")).click(); //Clock
    Thread.sleep(3000);
}
}
