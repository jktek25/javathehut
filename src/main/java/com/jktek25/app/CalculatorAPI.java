package com.jktek25.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * REST API controller for calculator operations.
 */
@RestController
@SpringBootApplication
public class CalculatorAPI {

    /**
     * The main method to run the Spring Boot application.
     * @param args
     */
    public static void main(final String[] args) {
        // This main method is not necessary for the Spring Boot application
        // to run, but you can use it for testing purposes if needed.
        SpringApplication.run(CalculatorAPI.class, args);
    }

    /**
     * Record class to represent a status response.
     * @param status The status of the API.
     */
    public record StatusResponse(String status) { }

    /**
     * Endpoint to return the status of the API.
     * @return A JSON string with the API status.
     */
    @GetMapping("/api/status")
    public final StatusResponse getStatus() {
        return new StatusResponse("UP");
    }

    /**
     * Record class to represent a message response.
     * @param message The message to be returned in the response.
     */
    public record MessageResponse(String message) { }

    /**
     * Endpoint to return a simple hello message.
     * @return A JSON string with a hello message.
     */
    @GetMapping("/api/hello")
    public final MessageResponse sayHello() {
        return new MessageResponse("Hello from Java API!");
    }

    /**
     * Endpoint to add two numbers.
     * @param num1 The first number.
     * @param num2 The second number.
     * @return A JSON string with the result of the addition.
     */
    @GetMapping("/api/add")
    public final String addNumbers(
        @RequestParam(value = "num1", required = true) final int num1,
        @RequestParam(value = "num2", required = true) final int num2) {
        Calculator calculator = new Calculator();
        int result = calculator.add(num1, num2);
        return "{\"result\": " + result + "}";
    }

    /**
     * Endpoint to subtract two numbers.
     * @param num1 The first number.
     * @param num2 The second number.
     * @return A JSON string with the result of the subtraction.
     */
    @GetMapping("/api/sub")
    public final String subtractNumbers(
        @RequestParam(value = "num1", required = true) final int num1,
        @RequestParam(value = "num2", required = true) final int num2) {
        Calculator calculator = new Calculator();
        int result = calculator.sub(num1, num2);
        return "{\"result\": " + result + "}";
    }

    /**
     * Endpoint to multiply two numbers.
     * @param num1 The first number.
     * @param num2 The second number.
     * @return A JSON string with the result of the multiplication.
     */
    @GetMapping("/api/multiply")
    public final String multiplyNumbers(
        @RequestParam(value = "num1", required = true) final int num1,
        @RequestParam(value = "num2", required = true) final int num2) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(num1, num2);
        return "{\"result\": " + result + "}";
    }

    /**
     * Endpoint to divide two numbers.
     * @param num1 The first number.
     * @param num2 The second number.
     * @return A JSON string with the result of the division.
     */
    @GetMapping("/api/divide")
    public final String divideNumbers(
        @RequestParam(value = "num1", required = true) final int num1,
        @RequestParam(value = "num2", required = true) final int num2) {
        Calculator calculator = new Calculator();
        int result = calculator.divide(num1, num2);
        return "{\"result\": " + result + "}";
    }

    /**
     * Exception handler for missing request parameters.
     * @param ex The exception thrown when a required parameter is missing.
     * @return A JSON string with an error message.
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String handleMissingParameter(
            final MissingServletRequestParameterException ex) {

        return "{\"error\": \"Missing required parameter: "
            + ex.getParameterName() + "\"}";
    }
}

