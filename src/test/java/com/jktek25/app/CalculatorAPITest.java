package com.jktek25.app;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import io.restassured.parsing.Parser;
import io.restassured.RestAssured;

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
    /**
     * Endpoint path for the API addition.
     */
    private static final String ADD_ENDPOINT = "/api/add";
    /**
     * Endpoint path for the API subtraction.
     */
    private static final String SUBTRACT_ENDPOINT = "/api/sub";
    /**
     * Endpoint path for the API multiplication.
     */
    private static final String MULTIPLY_ENDPOINT = "/api/multiply";
    /**
     * Endpoint path for the API division.
     */
    private static final String DIVIDE_ENDPOINT = "/api/divide";
    /**
     * The HTTP status code for a successful response.
     */
    private static final int RESPONSE_SUCCESS = 200;
    /**
     * The HTTP status code for a bad request response.
     */
    private static final int RESPONSE_BAD_REQUEST = 400;

    @BeforeAll
    static void setup() {
        // Force RestAssured to parse plain text responses as JSON
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

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

    /**
     * Test the /api/add endpoint with valid parameters.
     *
     * @param num1 the first number to add
     * @param num2 the second number to add
     * @param exp the expected result of the addition
     */
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "1, 2, 3",
        "10, 10, 20",
        "-1, -2, -3",
        "100, 11, 111",
        "2147483647, 1, -2147483648",
        "-2147483648, -1, 2147483647"
    })
    public final void verifyCalculatorAPIAdd(final int num1, final int num2,
        final int exp) {
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
            .queryParam("num2", num2)
        .when()
            .get(ADD_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_SUCCESS)
            .body("result", equalTo(exp));
    }

    /**
     * Test the /api/add endpoint with valid with no query parameters.
     */
    @Test
    public final void verifyCalculatorAPIAddNoParams() {
        given()
            .baseUri(BASE_URI)
        .when()
            .get(ADD_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }

    /**
     * Test the /api/add endpoint with valid with one query parameter.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    public final void verifyCalculatorAPIAddOneParam() {
        int num1 = 5;
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
        .when()
            .get(ADD_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }

    /**
     * Test the /api/sub endpoint with valid parameters.
     *
     * @param num1 the first number to subtract
     * @param num2 the second number to subtract
     * @param exp the expected result of the subtraction
     */
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "3, 2, 1",
        "5, 3, 2",
        "10, 10, 0",
        "-1, -2, 1",
        "0, -1000, 1000",
        "2147483647, -1, -2147483648",
        "-2147483648, 1, 2147483647"
    })
        public final void verifyCalculatorAPISub(final int num1,
            final int num2, final int exp) {
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
            .queryParam("num2", num2)
        .when()
            .get(SUBTRACT_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_SUCCESS)
            .body("result", equalTo(exp));
    }

    /**
     * Test the /api/sub endpoint with valid with no query parameters.
     */
    @Test
    public final void verifyCalculatorAPISubNoParams() {
        given()
            .baseUri(BASE_URI)
        .when()
            .get(SUBTRACT_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }

    /**
     * Test the /api/sub endpoint with valid with one query parameter.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    public final void verifyCalculatorAPISubOneParam() {
        int num1 = 5;
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
        .when()
            .get(SUBTRACT_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }

    /**
     * Test the /api/multiply endpoint with valid parameters.
     *
     * @param num1 the first number to multiply
     * @param num2 the second number to multiply
     * @param exp the expected result of the multiplication
     */
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "3, 2, 6",
        "5, 3, 15",
        "10, 10, 100",
        "-1, -2, 2",
        "5, 5, 25",
        "0, -1000, 0",
        "2147483647, -1, -2147483647",
        "-2147483648, 1, -2147483648"
    })
    public final void verifyCalculatorAPIMultiply(final int num1,
        final int num2, final int exp) {
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
            .queryParam("num2", num2)
        .when()
            .get(MULTIPLY_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_SUCCESS)
            .body("result", equalTo(exp));
    }

    /**
     * Test the /api/multiply endpoint with valid with no query parameters.
     */
    @Test
    public final void verifyCalculatorAPIMultiplyNoParams() {
        given()
            .baseUri(BASE_URI)
        .when()
            .get(MULTIPLY_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }

    /**
     * Test the /api/multiply endpoint with valid with one query parameter.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    public final void verifyCalculatorAPIMultiplyOneParam() {
        int num1 = 5;
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
        .when()
            .get(MULTIPLY_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }

    /**
     * Test the /api/divide endpoint with valid parameters.
     *
     * @param num1 the first number to divide
     * @param num2 the second number to divide
     * @param exp the expected result of the division
     */
    @ParameterizedTest
    @CsvSource({
        "0, 1, 0",
        "3, 1, 3",
        "500, 2, 250",
        "10, 10, 1",
        "20, 10, 2",
        "55555, 5, 11111",
        "0, -1, 0",
        "2147483647, -1, -2147483647",
        "-2147483648, 1, -2147483648"
    })
    public final void verifyCalculatorAPIDivide(final int num1,
        final int num2, final int exp) {
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
            .queryParam("num2", num2)
        .when()
            .get(DIVIDE_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_SUCCESS)
            .body("result", equalTo(exp));
    }

    /**
     * Test the /api/divide endpoint with valid with no query parameters.
     */
    @Test
    public final void verifyCalculatorAPIDivideNoParams() {
        given()
            .baseUri(BASE_URI)
        .when()
            .get(DIVIDE_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }

    /**
     * Test the /api/divide endpoint with valid with one query parameter.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    public final void verifyCalculatorAPIDivideOneParam() {
        int num1 = 5;
        given()
            .baseUri(BASE_URI)
            .queryParam("num1", num1)
        .when()
            .get(DIVIDE_ENDPOINT)
        .then()
            .log().all()
            .statusCode(RESPONSE_BAD_REQUEST)
            .body("result", nullValue());
    }
}
