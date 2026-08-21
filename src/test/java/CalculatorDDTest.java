package test.java;
// package org.example;


// Import the JUnit 5 Jupiter library components
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.Calculator;


public class CalculatorDDTest {
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
        var oCalc = new Calculator();
        int retVal = oCalc.add(num1, num2);
        assertEquals(exp, retVal);
    }
    
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "3, 2, 1",
        "10, 10, 0",
        "-1, -2, 1",
        "2147483647, -1, -2147483648",
        "-2147483648, 1, 2147483647"
    })
    void subTest(int num1, int num2, int exp) {
        var oCalc = new Calculator();
        int retVal = oCalc.sub(num1, num2);
        assertEquals(exp, retVal);
    }
    
    @ParameterizedTest
    @CsvSource({
        "0, 0, 0",
        "3, 2, 1",
        "10, 10, 0",
        "-1, -2, 1",
        "1000, 1000, 0",
        "5000, 5000, 0"
    })    
    void recursiveSubTest(int num1, int num2, int exp) {
        var oCalc = new Calculator();
        int retVal = oCalc.recursiveSub(num1, num2);
        assertEquals(exp, retVal);
    }
}
