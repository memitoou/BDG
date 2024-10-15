package Proyecto1.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class UsuarioSteps {

    private Response response;

    @Given("que la API de usuarios está en ejecución")
    public void queLaAPIDeUsuariosEstaEnEjecucion() {
        // Aquí puedes verificar que la API esté activa
        // Por ejemplo, puedes hacer una solicitud de "saludo" para comprobar
        RestAssured.given().baseUri("http://tu-api.com/api/usuarios");
    }

    @When("se envía una solicitud GET a la API de usuarios")
    public void seEnvíaUnaSolicitudGETAlaAPIDeUsuarios() {
        response = RestAssured.given()
                .when()
                .get("/usuarios");
    }

    @Then("la respuesta debe tener un código de estado {int}")
    public void laRespuestaDebeTenerUnCodigoDeEstado(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("se deben retornar los usuarios")
    public void seDebenRetornarLosUsuarios() {
        response.then().body("size()", is(greaterThan(0))); // Verifica que la respuesta no esté vacía
    }

    @When("se envía una solicitud POST a la API de usuarios con los siguientes datos:")
    public void seEnvíaUnaSolicitudPOSTAlaAPIDeUsuarios(String nombre, String email) {
        response = RestAssured.given()
                .contentType("application/json")
                .body("{\"nombre\":\"" + nombre + "\", \"email\":\"" + email + "\"}")
                .when()
                .post("/usuarios");
    }

    @Then("el usuario debe ser creado con los siguientes datos:")
    public void elUsuarioDebeSerCreadoConLosSiguientesDatos(String nombre, String email) {
        response.then()
                .body("nombre", equalTo(nombre))
                .body("email", equalTo(email));
    }

    @When("se envía una solicitud PUT a la API de usuarios con ID {int} y los siguientes datos:")
    public void seEnvíaUnaSolicitudPUTAlaAPIDeUsuarios(int id, String nombre, String email) {
        response = RestAssured.given()
                .contentType("application/json")
                .body("{\"nombre\":\"" + nombre + "\", \"email\":\"" + email + "\"}")
                .when()
                .put("/usuarios/" + id);
    }

    @Then("el usuario debe ser actualizado con los siguientes datos:")
    public void elUsuarioDebeSerActualizadoConLosSiguientesDatos(String nombre, String email) {
        response.then()
                .body("nombre", equalTo(nombre))
                .body("email", equalTo(email));
    }

    @When("se envía una solicitud DELETE a la API de usuarios con ID {int}")
    public void seEnvíaUnaSolicitudDELETEAlaAPIDeUsuarios(int id) {
        response = RestAssured.given()
                .when()
                .delete("/usuarios/" + id);
    }

    @Then("el usuario con ID {int} no debe existir en la base de datos")
    public void elUsuarioConIDNoDebeExistirEnLaBaseDeDatos(int id) {
        // Puedes hacer una verificación de existencia
        response = RestAssured.given()
                .when()
                .get("/usuarios/" + id);
        response.then().statusCode(404); // Verifica que el usuario no existe
    }
}

