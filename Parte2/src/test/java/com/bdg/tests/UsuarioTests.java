package com.bdg.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue; 

public class UsuarioTests {  

    static {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testListarUsuarios() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users?page=1") 
        .then()
            .statusCode(200)
            .body("data.size()", equalTo(6)); 
    }

    @Test
    public void testRegistrarUsuario() {
        String nuevoUsuario = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"city123\" }";

        given()
            .contentType(ContentType.JSON)
            .body(nuevoUsuario)
        .when()
            .post("/register") 
        .then()
            .statusCode(200)
            .body("id", notNullValue()) 
            .body("token", notNullValue());
    }

    @Test
    public void testActualizarUsuario() {
        String usuarioActualizado = "{ \"name\": \"Juan Actualizado\", \"job\": \"Desarrollador Actualizado\" }";

        given()
            .contentType(ContentType.JSON)
            .body(usuarioActualizado)
        .when()
            .put("/users/2") 
        .then()
            .statusCode(200)
            .body("name", equalTo("Juan Actualizado")); 
    }

    @Test
    public void testEliminarUsuario() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .delete("/users/2") 
        .then()
            .statusCode(204); 
    }
}

