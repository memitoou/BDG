package com.bdg.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    @Test
    public void verifyGetApiCall() {
        // Realizar una solicitud GET a la API
        Response response = SerenityRest.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/posts/1")
                .get();

        // Verificar el código de respuesta
        response.then().statusCode(200);

        // Verificar algunos campos de la respuesta JSON
        response.then().body("userId", equalTo(1))
                        .body("id", equalTo(1))
                        .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    @Test
    public void verifyPostApiCall() {
        // Crear una solicitud POST
        SerenityRest.given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/posts")
                .contentType("application/json")
                .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .post()
                .then().statusCode(201)
                .and().body("title", equalTo("foo"))
                .and().body("body", equalTo("bar"))
                .and().body("userId", equalTo(1));
    }
}

