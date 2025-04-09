package appTests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class DriverManager {

    private static AppiumDriver driver;

    public static void initializeDriver() {
        try {
            String platform = System.getProperty("platform", "android");
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/test/java/appTests/capabilities/" + platform.toLowerCase() + ".properties");
            props.load(fis);

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", props.getProperty("platformName"));
            caps.setCapability("appium:deviceName", props.getProperty("deviceName"));
            caps.setCapability("appium:platformVersion", props.getProperty("platformVersion"));
            caps.setCapability("appium:automationName", props.getProperty("automationName"));
            caps.setCapability("appium:app", System.getProperty("user.dir") + "/" + props.getProperty("app"));
            caps.setCapability("appium:autoGrantPermissions", Boolean.parseBoolean(props.getProperty("autoGrantPermissions")));
            caps.setCapability("appium:fullReset", Boolean.parseBoolean(props.getProperty("fullReset")));
            caps.setCapability("appium:noReset", Boolean.parseBoolean(props.getProperty("noReset")));

            URL serverUrl = new URL("http://127.0.0.1:4723");
            driver = new AppiumDriver(serverUrl, caps);

        } catch (Exception e) {
            throw new RuntimeException("Error al iniciar el AppiumDriver", e);
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
