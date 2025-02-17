package ui.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;
import java.util.function.Function;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebCapabilities {

    public static WebDriver driver;

    public static WebDriver getintDriver() {
        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver driver = new ChromeDriver();

        return driver;


    }

    public WebElement fluentWait(String Elements) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement elementStaled = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(Elements));

            }
        });
        return elementStaled;
    }

    public WebElement IsVisible(WebElement Elements) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement elementStaled = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                Elements.isDisplayed();
                return Elements;

            }
        });
        return elementStaled;
    }


    public void IsEnabled(WebElement Elements) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement elementStaled = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                Elements.isEnabled();
                return Elements;

            }
        });

    }

    public static void uiClick(WebElement element) {
        element.click();
    }

    public static String screenshot(WebDriver driver, String screenshotName)
    {


        // Copy the file to a location and use try catch block to handle exceptions
        try {
            String sss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            System.out.println("ScreenShot===>" + sss.length());
            return sss;

        } catch (Exception e) {
            System.out.println(e);
            return "";
        }

    }

    public void closeBrowser() {

        driver.quit();
    }
}