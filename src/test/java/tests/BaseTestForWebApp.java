package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestForWebApp {

    private AppiumDriverLocalService appiumService;
    AndroidDriver driver;

    @BeforeClass
    public void startAppiumServer() throws InterruptedException {

        // Create Appium server instance
        appiumService = new AppiumServiceBuilder()
//                .usingPort(selectedPort)
                .usingAnyFreePort() // Use a random free port
                .withAppiumJS(new File("C:/Users/safwa/AppData/Roaming/npm/node_modules/appium/build/lib/main.js")) // Path to Appium executable
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload")  // Allow Appium to auto-download Chromedriver
                .withLogFile(new File("appium-server.log")) // Optional: Log Appium server output
                .build();


        // Start Appium server
        appiumService.start();
        System.out.println("Appium server started at: " + appiumService.getUrl());

        // Wait for the server to start
        Thread.sleep(2000);  // Give Appium time to start

    }

    @Test
    public void setUp() throws MalformedURLException {
        System.out.println("Starting setUp");
        URL appiumServerUrl = appiumService.getUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2API34");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        WebDriverManager.chromedriver().setup();
        capabilities.setCapability("chromedriverExecutable", WebDriverManager.chromedriver().getDownloadedDriverPath());

        driver = new AndroidDriver(appiumServerUrl, capabilities);
        System.out.println("ending setUp");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully");
        }
    }


    @AfterClass
    public void stopAppiumServer() {
        // Stop Appium server
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            System.out.println("Appium server stopped.");
        }
        int port = 8202; // You can dynamically select this port based on your test logic
        killPort(port);
    }

    public void killPort(int port) {

        // Kill the process occupying the port (e.g., port 8200)
        String command = "netstat -ano | findstr :" + port;  // for Windows
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Extract PID from the command output
                String[] tokens = line.split("\\s+");
                String pid = tokens[tokens.length - 1];
                // Kill the process using taskkill
                Runtime.getRuntime().exec("taskkill /PID " + pid + " /F");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
