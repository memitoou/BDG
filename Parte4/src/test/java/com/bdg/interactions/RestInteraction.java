package com.bdg.interactions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestInteraction {

    public RestInteraction() {
        RestAssured.baseURI = "https://reqres.in"; // Configuración base de la API
    }

    public Response get(String endpoint) {
        return RestAssured.given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }
}

