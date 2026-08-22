package com.jktek25.app;

/**
 * Calculator
 *
 * A simple calculator class that provides basic arithmetic operations such as
 * addition and subtraction. It also includes recursive methods for addition
 * and subtraction.
 */
public class Calculator {

    /**
     * Adds two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the sum of the two integers
     */
    public int add(final int num1, final int num2) {
        return (num1 + num2);
    }

    /**
     * Subtracts two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the difference of the two integers
     */
    public int sub(final int num1, final int num2) {
        return (num1 - num2);
    }

    /**
     * Recursively adds two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the sum of the two integers
     */
    public int recursiveAdd(final int num1, final int num2) {
        if (num2 == 0) {
            return num1;
        } else if (num2 > 0) {
            return this.recursiveAdd(num1 + 1, num2 - 1);
        } else if (num2 < 0) {
            return this.recursiveAdd(num1 - 1, num2 + 1);
        } else {
            throw new Error("Unexpected and unhandled case");
        }
    }

    /**
     * Recursively subtracts two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the difference of the two integers
     */
    public int recursiveSub(final int num1, final int num2) {
        if (num2 == 0) {
            return num1;
        } else if (num2 > 0) {
            return this.recursiveSub(num1 - 1, num2 - 1);
        } else if (num2 < 0) {
            return this.recursiveSub(num1 + 1, num2 + 1);
        } else {
            throw new Error("Unexpected and unhandled case");
        }
    }

}
