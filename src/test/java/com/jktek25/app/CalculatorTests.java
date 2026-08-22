package com.jktek25.app;

// Import the JUnit 5 Jupiter library components
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CalculatorTests
 * 
 * Designed to test the Calculator class. This is uses a more advacned form of data driven testing using the JUnit 5 ParameterizedTest and CsvSource annotations. This allows for a single test method to be run multiple times with different input values and expected results.
 */
public class CalculatorTests {
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
    void addTest(int num1, int num2, int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }
    
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
    void subTest(int num1, int num2, int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.sub(num1, num2);
        assertEquals(exp, retVal);
    }
    
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "3, 2, 1",
        "5, 3, 2",
        "10, 10, 0",
        "-1, -2, 1",
        "0, -1000, 1000",
        "1000, 1000, 0", // Keep it small for recursion
        "5000, 5000, 0"
    })    
    void recursiveSubTest(int num1, int num2, int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveSub(num1, num2);
        assertEquals(exp, retVal);
    }
}
// -----