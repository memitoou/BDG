package com.bdg.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserApiSteps {
    private Response response;

    @Given("the user API is accessible")
    public void theUserApiIsAccessible() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @When("I send a request to list users")
    public void iSendARequestToListUsers() {
        response = given().get("/users");
    }

    @Then("the response should contain at least one user")
    public void theResponseShouldContainAtLeastOneUser() {
        assertThat(response.jsonPath().getList("data").size(), greaterThan(0));
    }

    @When("I send a request to register a new user with name {string} and job {string}")
    public void iSendARequestToRegisterANewUser(String name, String job) {
        response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}")
                .post("/users");
    }

    @Then("the response should have a status code of {int}")
    public void theResponseShouldHaveAStatusCodeOf(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("the response should contain the name {string}")
    public void theResponseShouldContainTheName(String name) {
        assertThat(response.jsonPath().getString("name"), equalTo(name));
    }

    @Then("the response should contain the job {string}")
    public void theResponseShouldContainTheJob(String job) {
        assertThat(response.jsonPath().getString("job"), equalTo(job));
    }

    @When("I send a request to register a new user without name and job")
    public void iSendARequestToRegisterANewUserWithoutData() {
        response = given()
                .header("Content-Type", "application/json")
                .body("{}")  // Sending an empty body
                .post("/users");
    }

    @Then("the response should contain an error message")
    public void theResponseShouldContainAnErrorMessage() {
        assertThat(response.jsonPath().getString("error"), equalTo("Missing name and job"));
    }

    @When("I send a request to update the user with ID {int} and name {string} and job {string}")
    public void iSendARequestToUpdateTheUser(int id, String name, String job) {
        response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}")
                .put("/users/" + id);
    }

    @When("I send a request to delete the user with ID {int}")
    public void iSendARequestToDeleteTheUser(int id) {
        response = given().delete("/users/" + id);
    }
}

