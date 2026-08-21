package test.java;
// package org.example;

// Import the JUnit 5 Jupiter library components
import org.junit.jupiter.api.Test;

import main.java.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void add2Plus2Is4() {
        int num1 = 2;
        int num2 = 2;
        int exp = 4;
        var oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }
    
    @Test
    void add0Plus0Is0() {
        int num1 = 0;
        int num2 = 0;
        int exp = 0;
        var oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void addNeg1PlusNeg2IsNeg3() {
        int num1 = -1;
        int num2 = -2;
        int exp = -3;
        var oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void addMaxInt() {
        int num1 = 2147483647;
        int num2 = 1;
        int exp = -2147483648;
        var oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void addMinInt() {
        int num1 = -2147483648;
        int num2 = -1;
        int exp = 2147483647;
        var oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void recursiveAdd2Plus2Is4() {
        int num1 = 2;
        int num2 = 2;
        int exp = 4;
        var oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }
    
    @Test
    void recursiveAdd0Plus0Is0() {
        int num1 = 0;
        int num2 = 0;
        int exp = 0;
        var oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void recursiveAddNeg1PlusNeg2IsNeg3() {
        int num1 = -1;
        int num2 = -2;
        int exp = -3;
        var oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }

    @Test
    void recursiveAddMax() {
        int num1 = 1000;
        int num2 = 1000;
        int exp = 2000;
        var oCalc = new Calculator();
        int retVal = oCalc.recursiveAdd(num1, num2);
        assertEquals(exp, retVal);
    }
}
