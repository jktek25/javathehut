package com.jktek25.app;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Calculator API.
 */
public class CalculatorAPITest {

    /**
     * Base URI for the API.
     */
    private static final String BASE_URI = "http://localhost:8080";
    /**
     * Endpoint paths for the API.
     */
    private static final String HELLO_ENDPOINT = "/api/hello";
    /**
     * Endpoint path for the API status.
     */
    private static final String STATUS_ENDPOINT = "/api/status";
    // private static final String ADD_ENDPOINT = "/api/add";
    // private static final String SUBTRACT_ENDPOINT = "/api/sub";
    /**
     * The HTTP status code for a successful response.
     */
    private static final int RESPONSE_SUCCESS = 200;

    /**
     * Test the /api/status endpoint.
     */
    @Test
    public final void verifyCalculatorAPIStatus() {
        given()
            .baseUri(BASE_URI)
        .when()
            .get(STATUS_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_SUCCESS)
            .contentType("application/json")
            .body("status", equalTo("UP"));
    }

    /**
     * Test the /api/hello endpoint.
     */
    @Test
    public final void verifyCalculatorAPIHello() {
        given()
            .baseUri(BASE_URI)
        .when()
            .get(HELLO_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_SUCCESS)
            .contentType("application/json")
            .body("message", equalTo("Hello from Java API!"));
    }
}
