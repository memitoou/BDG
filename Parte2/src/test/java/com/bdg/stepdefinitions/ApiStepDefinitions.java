package com.bdg.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApiStepDefinitions {
    private static final Logger logger = Logger.getLogger(ApiStepDefinitions.class.getName());
    private Response response;
    private String token;

    @Before
    public void setup() {
        // Configuraciones iniciales antes de cada escenario
        System.setProperty("java.util.logging.ConsoleHandler.level", "INFO");
        logger.log(Level.INFO, "Configuraciones iniciales completadas.");
        System.setProperty("API_BASE_URL", "https://reqres.in/api");
        RestAssured.baseURI = System.getProperty("API_BASE_URL"); // Establece la base URL
    }

    @Given("I set the base URL to {string}")
    public void i_set_the_base_url_to(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given().when().get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @When("I send a POST request to {string} with the following data")
    public void i_send_a_post_request_to_with_the_following_data(String endpoint, DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        response = given().contentType("application/json").body(data).post(endpoint);
    }

    @When("I send a PUT request to {string} with the following data")
    public void i_send_a_put_request_to_with_the_following_data(String endpoint, DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        response = given().contentType("application/json").body(data).put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = delete(endpoint);
    }

    @Given("I have a valid token")
    public void i_have_a_valid_token() {
        if (token == null) {
            throw new IllegalStateException("Token is not set. Please register a user first.");
        }
    }

    @When("I send a request to a protected resource")
    public void i_send_a_request_to_a_protected_resource() {
        response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://reqres.in/api/protected-resource");
    }

    @Then("I should receive a successful response")
    public void i_should_receive_a_successful_response() {
        response.then().statusCode(200); // Ajusta según tu lógica
    }

    @Given("I register a user with the following data")
    public void i_register_a_user_with_the_following_data(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        response = given().contentType("application/json")
                .body(data)
                .post("https://reqres.in/api/register");
        response.then().statusCode(200);
        token = response.jsonPath().getString("token");
    }

}

