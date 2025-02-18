package stepdefinitions.api;

import api.ApiConstant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static api.ApiConstant.BOOKING_BASE_PATH;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PostAPISteps {
    private RequestSpecification request;
    Response response;
    private JSONObject requestBody;

    @Given("Add booking details as request Payload")
    public void add_place_payload() throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get(ApiConstant.PostBookingRequest)));
        requestBody = new JSONObject(jsonContent);
        RestAssured.baseURI = BOOKING_BASE_PATH;
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString());
    }

    @When("perform POST request for {string} endpoint")
    public void callPostapiRequest(String endpoint) {
        response = request.post(endpoint);

    }

    @Then("response should have Status code {int}")
    public void userGetsTheSuccessResponseWithStatusCode(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("response body field {string} should not be null")
    public void validateresponsebody(String responseKey) {

        System.out.println(response.body().asString());
        assertNotNull(response.body().jsonPath().get(responseKey).toString());

    }
}
