package api.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIsteps {

    private Response response;

    private final String BASE_URL = "https://dummyapi.io/data/v1";
    private final String APP_ID = "63a804408eb0cb069b57e43a"; // Replace with your real DummyAPI App ID

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given()
                .baseUri(BASE_URL)
                .header("app-id", APP_ID)
                .when()
                .get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain a list of users")
    public void the_response_should_contain_a_list_of_users() {
        response.then().body("data", notNullValue());
    }

    @Then("the response should contain the ID {string}")
    public void the_response_should_contain_the_id(String expectedId) {
        response.then().body("id", equalTo(expectedId));
    }
}
