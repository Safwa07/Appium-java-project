//package drivers;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class DriverManager {
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//    public static void setDriver(String platform) throws MalformedURLException {
//        if ("android".equalsIgnoreCase(platform)) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2API34");
////            capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/app.apk");
//            driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities));
//        } else {
//            throw new IllegalArgumentException("Unsupported platform: " + platform);
//        }
//    }
//    public static void quitDriver() {
//        if (getDriver() != null) {
//            getDriver().quit();
//            driver.remove();
//        }
//    }
//}
//
