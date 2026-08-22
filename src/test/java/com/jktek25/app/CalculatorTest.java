package com.jktek25.app;

// Import the JUnit 5 Jupiter library components
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * CalculatorTest
 *
 * Adding some basic unit tests for the Calculator class. First cut as the
 * Calculator class is being developed.
 *
 */
public class CalculatorTest {

    /**
     * Test that 2 + 2 = 4.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void add2Plus2Is4() {
        int num1 = 2;
        int num2 = 2;
        int exp = 4;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that 0 + 0 = 0.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void add0Plus0Is0() {
        int num1 = 0;
        int num2 = 0;
        int exp = 0;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that 2 - 2 = 0.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void addNeg1PlusNeg2IsNeg3() {
        int num1 = -1;
        int num2 = -2;
        int exp = -3;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that 1000 + 1000 = 2000.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void addMaxInt() {
        int num1 = 2147483647;
        int num2 = 1;
        int exp = -2147483648;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that -2147483648 + -1 = 2147483647.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void addMinInt() {
        int num1 = -2147483648;
        int num2 = -1;
        int exp = 2147483647;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that the recursive add method works correctly.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    void recursiveAdd2Plus2Is4() {
        int num1 = 2;
        int num2 = 2;
        int exp = 4;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that the recursive add method works correctly for negative numbers.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void recursiveAdd0Plus0Is0() {
        int num1 = 0;
        int num2 = 0;
        int exp = 0;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that the recursive add method works correctly for negative numbers.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void recursiveAddNeg1PlusNeg2IsNeg3() {
        int num1 = -1;
        int num2 = -2;
        int exp = -3;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    /**
     * Test that the recursive add method works correctly for large numbers.
     */
    @Test
    @SuppressWarnings("magicnumber") // For general linters
    final void recursiveAddMax() {
        int num1 = 1000;
        int num2 = 1000;
        int exp = 2000;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }
}
