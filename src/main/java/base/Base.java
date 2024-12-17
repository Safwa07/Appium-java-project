package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.*;
import utils.ScreenshotHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    protected AppiumDriverLocalService appiumService;
//    protected AndroidDriver driver;
    public static AndroidDriver driver;

    FileInputStream inputStream;
    Properties prop;
//    ScreenshotHelper screenshotHelper = new ScreenshotHelper();
public AndroidDriver getDriver() {
    return driver;
}
protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public Base() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @BeforeSuite
    public void setUpAllureListener() {
        TestNG testNG = new TestNG();
        testNG.addListener(new AllureTestNg());
    }
//    @Step("Launching the Appium service")
    @BeforeClass
    public void startAppiumServer() throws InterruptedException {

        appiumService = new AppiumServiceBuilder()
//                .usingPort(selectedPort)
                .usingAnyFreePort() // Use a random free port
                .withAppiumJS(new File("C:/Users/safwa/AppData/Roaming/npm/node_modules/appium/build/lib/main.js")) // Path to Appium executable
                .withArgument(() -> "--log-level", "error") // Set log level to error
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload")  // Allow Appium to auto-download Chromedriver
                .withLogFile(new File("appium-server.log")) // Optional: Log Appium server output
                .build();


        // Start Appium server
        appiumService.start();
        System.out.println("Appium server started at: " + appiumService.getUrl());
        Thread.sleep(2000);  // Give Appium time to start

    }

//    @Step("Launching the application")
    @Parameters({"deviceName", "platformName"})
    @BeforeMethod
//    @Test
    public void setUp(String deviceName, String platformName) throws IOException, InterruptedException {
        System.out.println("Starting setUp");
        URL appiumServerUrl = appiumService.getUrl();

        File propFile = new File("src/main/resources/config/config.properties");
        try {
            inputStream = new FileInputStream(propFile);
            prop = new Properties();
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println();
        }

        if (platformName.equalsIgnoreCase("android")) {
            File androidApp = new File(prop.getProperty("androidAppPath"));

            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
            capabilities.setCapability(MobileCapabilityType.APP, androidApp.getAbsolutePath());

            driver = new AndroidDriver(appiumServerUrl, capabilities);
            Thread.sleep(3000);

        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
//            screenshotHelper.takeScreenshot(driver);

            driver.quit();
        }
    }

    @AfterClass
    public void stopAppiumServer() {
        // Stop Appium server
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            System.out.println("Appium server stopped.");
        }
    }
}
