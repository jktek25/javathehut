package com.jktek25.app;

// Import the JUnit 5 Jupiter library components
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * CalculatorTests
 *
 * Designed to test the Calculator class. This is uses a more advacned form of
 * data driven testing using the JUnit 5 ParameterizedTest and CsvSource
 * annotations. This allows for a single test method to be run multiple times
 * with different input values and expected results.
 */
public class CalculatorTests {

    /**
     * Test the add method of the Calculator class with various inputs and
     * expected results.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @param exp the expected result of adding num1 and num2
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
    final void addTest(final int num1, final int num2, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test the sub method of the Calculator class with various inputs and
     * expected results.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @param exp the expected result of subtracting num2 from num1
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
    final void subTest(final int num1, final int num2, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.sub(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test the recursiveAdd method of the Calculator class with various
     * inputs and expected results.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @param exp the expected result of recursively adding num1 and num2
     */
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "3, 2, 5",
        "5, 3, 8",
        "10, 10, 20",
        "-1, -2, -3",
        "0, -1000, -1000",
        "1000, 1000, 2000", // Keep it small for recursion
        "5000, 5000, 10000"
    })
    final void recursiveAddTest(final int num1, final int num2, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test the recursiveSub method of the Calculator class with various inputs
     * and expected results.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @param exp the expected result of recursively subtracting num2 from num1
     */
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
    final void recursiveSubTest(final int num1, final int num2, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveSub(num1, num2);
        assertEquals(exp, retVal);
    }
}
// -----
