package com.bdg.steps;

import com.bdg.interactions.RestInteraction;
import com.bdg.models.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserApiSteps {

    private User user;
    private RestInteraction restInteraction = new RestInteraction();

    @Given("the user API is accessible")
    public void theUserApiIsAccessible() {
        // Verifica que la API esté accesible
        restInteraction.get("/api/users/2").then().statusCode(200);
    }

    @When("I retrieve the user with ID {int}")
    public void iRetrieveTheUserWithID(int id) {
        // Guarda la respuesta del endpoint en el modelo
        user = restInteraction.get("/api/users/" + id).as(User.class);
    }

    @Then("I should see that the user ID is {int}, email is {string}, first name is {string}, and last name is {string}")
    public void iShouldSeeUserDetails(int id, String email, String firstName, String lastName) {
        // Valida el contenido del JSON
        assertThat(user.getId(), equalTo(id));
        assertThat(user.getEmail(), equalTo(email));
        assertThat(user.getFirstName(), equalTo(firstName));
        assertThat(user.getLastName(), equalTo(lastName));
    }
}

