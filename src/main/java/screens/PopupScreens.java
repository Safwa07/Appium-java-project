package screens;

import base.Base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class PopupScreens extends Base {
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_singleton\"]")
    private WebElement popup;

    public void tapOutsidePopup() {
        // Locate the popup
        System.out.println("1111111111111111");
        int popupX = popup.getLocation().getX();
        int popupY = popup.getLocation().getY();
        int popupWidth = popup.getSize().getWidth();
        int popupHeight = popup.getSize().getHeight();

        System.out.println("222222222222222");

        // Tap just outside the bottom of the popup
        int tapX = popupX + (popupWidth / 2); // Middle of the popup horizontally
        int tapY = popupY + popupHeight + 20; // 20 pixels below the bottom of the popup

        System.out.println("333333");

        // Create a PointerInput to simulate a "finger" touch
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tapOutside = new Sequence(finger, 0);

        System.out.println("4444444444");
        tapOutside.

                addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.

                        viewport(), tapX, tapY));
        tapOutside.

                addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapOutside.

                addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        System.out.println("555555555555");
        driver.perform(Collections.singletonList(tapOutside));
    }
}
