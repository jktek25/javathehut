package com.jktek25.app;

// Import the JUnit 5 Jupiter library components
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * CalculatorTest
 * 
 * Adding some basic unit tests for the Calculator class. First cut as the Calculator class is being developed.
 * 
 */
public class CalculatorTest {

    @Test
    void add2Plus2Is4() {
        int num1 = 2;
        int num2 = 2;
        int exp = 4;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }
    
    @Test
    void add0Plus0Is0() {
        int num1 = 0;
        int num2 = 0;
        int exp = 0;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void addNeg1PlusNeg2IsNeg3() {
        int num1 = -1;
        int num2 = -2;
        int exp = -3;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void addMaxInt() {
        int num1 = 2147483647;
        int num2 = 1;
        int exp = -2147483648;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void addMinInt() {
        int num1 = -2147483648;
        int num2 = -1;
        int exp = 2147483647;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void recursiveAdd2Plus2Is4() {
        int num1 = 2;
        int num2 = 2;
        int exp = 4;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }
    
    @Test
    void recursiveAdd0Plus0Is0() {
        int num1 = 0;
        int num2 = 0;
        int exp = 0;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void recursiveAddNeg1PlusNeg2IsNeg3() {
        int num1 = -1;
        int num2 = -2;
        int exp = -3;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void recursiveAddMax() {
        int num1 = 1000;
        int num2 = 1000;
        int exp = 2000;
        Calculator oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }
}
