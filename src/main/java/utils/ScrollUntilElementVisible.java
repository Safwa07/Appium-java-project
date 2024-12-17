package utils;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class ScrollUntilElementVisible extends Base {
    public void scrollUntilElementVisibleFunc(WebElement element, int maxScrolls) {
        int scrollCount = 0;

        while (scrollCount < maxScrolls) {
            try {
                if (element.isDisplayed()) {
                    System.out.println("Element is visible.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Element not visible. Scrolling...");
            }

            // Perform the swipe gesture (scroll)
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0);

            // Swipe from (x1, y1) to (x2, y2)
            int startX = 500;  // Start from the middle of the screen (adjust as needed)
            int startY = 1500; // Start swipe from bottom
            int endX = 500;    // Same x-axis
            int endY = 400;    // Swipe to the top of the screen

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));

            scrollCount++;
        }
        if (scrollCount == maxScrolls) {
            System.out.println("Reached maximum scroll attempts. Element not found.");
        }
    }
    public static void scrollToEnd() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);

        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        int startX = screenWidth / 2; // Middle of the screen (X-axis)
        int startY = (int) (screenHeight * 0.8); // Start near the bottom
        int endY = (int) (screenHeight * 0.2); // Scroll upwards

        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));
    }
}
