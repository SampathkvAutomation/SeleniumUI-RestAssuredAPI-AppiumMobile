package stepdefinitions.ui;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.base.WebCapabilities;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import io.cucumber.java.Scenario;

public class UITestSteps {
    private static WebDriver driver;
    private static WebElement serc;
    public static Scenario currentScenario;


    @Before
    public void init(Scenario scenario) {

        driver = WebCapabilities.getintDriver();
        currentScenario = scenario;
    }

    @Given("open google search")
    public void open_google() throws Throwable {
        driver.get("https://google.com");

        assertEquals("Google", driver.getTitle());

        Thread.sleep(5000);
    }

    @When("search for {string}")
    public void searchImages(String SearchText) throws Throwable {
        serc = driver.findElement(By.xpath("//*[@title='Search']"));
        serc.clear();
        serc.sendKeys(SearchText);
        serc.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Then("verify the results")
    public void searchResult() throws Throwable {
        WebCapabilities.uiClick(driver.findElement(By.xpath("//*[text()='Images']")));
        List<WebElement> searchList = new ArrayList<WebElement>();
        searchList = driver.findElements(By.tagName("img"));
        assertNotNull(searchList);
    }

    @And("Take Screen Shot {string}")
    public void stakeScreenShot(String filename) {
        Scenario scenario = currentScenario;
        String screenshot = WebCapabilities.screenshot(driver, filename);
        byte[] decodedScreenshot = Base64.getDecoder().decode(screenshot);
        scenario.attach(decodedScreenshot, "image/png", filename);
    }

    @After
    public void cleanUp() {
        driver.close();
    }
}