package stepdefinitions.mobile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.BaseMobileTest;
import mobile.LoginPage;

public class MobileAppSteps extends BaseMobileTest {
    private LoginPage loginPage;

    @Before
    public void setup() throws Exception {
        setupDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void cleanup() {
        tearDown();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Add any verification that we're on login page
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see the home screen")
    public void i_should_see_home_screen() {
        // Add home screen verification
    }
}