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
     * Test the multiply method of the Calculator class with various inputs and
     * expected results.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @param exp the expected result of multiplying num1 and num2
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
    final void multiplyTest(final int num1, final int num2, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.multiply(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test the divide method of the Calculator class with various inputs and
     * expected results.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @param exp the expected result of dividing num1 by num2
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
    final void divideTest(final int num1, final int num2, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.divide(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test the square method of the Calculator class with various inputs and
     * expected results.
     *
     * @param num the integer to be squared
     * @param exp the expected result of squaring num
     */
    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 1",
        "2, 4",
        "3, 9",
        "5, 25",
        "4, 16",
        "8, 64",
        "16, 256",
        "32, 1024",
        "64, 4096",
        "128, 16384",
        "10, 100",
        "-1, 1",
        "0, 0",
        "1000, 1000000"
    })
    final void squareTest(final int num, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.square(num);
        assertEquals(exp, retVal);
    }

    /**
     * Test the factorial method of the Calculator class with various inputs
     * and expected results.
     *
     * @param num the integer to calculate the factorial of
     * @param exp the expected result of calculating the factorial of num
     */
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "5, 120",
        "6, 720",
        "7, 5040",
        "8, 40320",
        "9, 362880",
        "10, 3628800"
    })
    final void factorialTest(final int num, final int exp) {
        Calculator oCalc = new Calculator();
        int retVal = oCalc.factorial(num);
        assertEquals(exp, retVal);
    }

    /**
     * Test isEven method of the Calculator class with various inputs and
     * expected results.
     * 
     * @param num the integer to check
     * @param exp the expected result of checking if num is even
     */
    @ParameterizedTest
    @CsvSource({
        "0, true",
        "1, false",
        "2, true",
        "3, false",
        "4, true",
        "5, false",
        "6, true",
        "7, false",
        "8, true",
        "9, false",
        "10, true"
    })
    final void isEvenTest(final int num, final boolean exp) {
        Calculator oCalc = new Calculator();
        boolean retVal = oCalc.isEven(num);
        assertEquals(exp, retVal);
    }

    /**
     * Test isOdd method of the Calculator class with various inputs and
     * expected results.
     *
     * @param num the integer to check
     * @param exp the expected result of checking if num is odd
     */
    @ParameterizedTest
    @CsvSource({
        "0, false",
        "1, true",
        "2, false",
        "3, true",
        "4, false",
        "5, true",
        "6, false",
        "7, true",
        "8, false",
        "9, true",
        "10, false"
    })
    final void isOddTest(final int num, final boolean exp) {
        Calculator oCalc = new Calculator();
        boolean retVal = oCalc.isOdd(num);
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
