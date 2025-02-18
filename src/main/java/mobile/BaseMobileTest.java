package mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.time.Duration;

public class BaseMobileTest {
    protected static AndroidDriver driver;
    protected static WebDriverWait wait;

    public void setupDriver() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Pixel_6_API_33")
                .setAutomationName("UiAutomator2")
                .setApp(System.getProperty("user.dir") + "test/resources/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}