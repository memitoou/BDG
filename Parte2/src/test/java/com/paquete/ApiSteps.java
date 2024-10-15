package com.tu_paquete;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class ApiSteps {
    private Response response;

    @Given("I set the base URL to {string}")
    public void setBaseUrl(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = get(endpoint);
    }

    @When("I send a POST request to {string} with the following data")
    public void sendPostRequest(String endpoint, DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        response = given().contentType("application/json")
                .body(data)
                .post(endpoint);
    }

    @When("I send a PUT request to {string} with the following data")
    public void sendPutRequest(String endpoint, DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        response = given().contentType("application/json")
                .body(data)
                .put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void sendDeleteRequest(String endpoint) {
        response = delete(endpoint);
    }

    @Then("the response status code should be {int}")
    public void checkStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }
}

