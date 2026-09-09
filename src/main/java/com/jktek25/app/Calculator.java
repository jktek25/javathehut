package com.jktek25.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Calculator
 *
 * A simple calculator class that provides basic arithmetic operations such as
 * addition and subtraction. It also includes recursive methods for addition
 * and subtraction.
 */
public class Calculator {
    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    /**
     * Adds two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the sum of the two integers
     */
    public int add(final int num1, final int num2) {
        logger.info("Adding {} and {}", num1, num2);
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
        logger.info("Subtracting {} from {}", num2, num1);
        return (num1 - num2);
    }

    /**
     * Multiplies two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the product of the two integers
     */
    public int multiply(final int num1, final int num2) {
        logger.info("Multiplying {} and {}", num1, num2);
        return (num1 * num2);
    }

    /**
     * Divides two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the quotient of the two integers
     */
    public int divide(final int num1, final int num2) {
        logger.info("Dividing {} by {}", num1, num2);
        if (num2 == 0) {
            logger.error("Attempted to divide by zero");
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (num1 / num2);
    }

    /**
     * Calculates the square of an integer.
     *
     * @param num the integer to square
     * @return the square of the integer
     */
    public int square(final int num) {
        logger.info("Calculating square of {}", num);
        return (num * num);
    }

    /**
     * Calculates the factorial of an integer.
     *
     * @param num the integer to calculate factorial for
     * @return the factorial of the integer
     */
    public int factorial(final int num) {
        logger.info("Calculating factorial of {}", num);
        if (num < 0) {
            logger.error("Attempted to calculate factorial of negative number: {}", num);
            throw new IllegalArgumentException(
                "Factorial is not defined for negative numbers.");
        }
        if (num == 0 || num == 1) {
            logger.info("Base case reached for factorial of {}", num);
            return 1;
        }
        return num * this.factorial(num - 1);
    }

    /**
     * Recursively adds two integers. Maximum allowed for num2 is 5000 to
     * prevent stack overflow.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the sum of the two integers
     */
    public int recursiveAdd(final int num1, final int num2) {
        final int maxLimit = 5000;
        if (num2 > maxLimit) {
            throw new IllegalArgumentException(
                "num2 is too large for recursion. Maximum allowed is "
                + maxLimit + ".");
        }
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
     * Recursively subtracts two integers. Maximum allowed for num2 is 5000 to
     * prevent stack overflow. Minimum allowed for num2 is -5000 to prevent
     * stack overflow.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the difference of the two integers
     */
    public int recursiveSub(final int num1, final int num2) {
        final int minLimit = -5000;
        final int maxLimit = 5000;
        if (num2 < minLimit) {
            throw new IllegalArgumentException(
                "num2 is too small for recursion. Minimum allowed is "
                + minLimit + ".");
        } else if (num2 > maxLimit) {
            throw new IllegalArgumentException(
                "num2 is too large for recursion. Maximum allowed is "
                + maxLimit + ".");
        }
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

    /**
     * Recursively multiplies two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the product of the two integers
     */
    public int recursiveMultiply(final int num1, final int num2) {
        if (num2 == 0) {
            return 0;
        } else if (num2 > 0) {
            return num1 + this.recursiveMultiply(num1, num2 - 1);
        } else {
            return -this.recursiveMultiply(num1, -num2);
        }
    }

    /**
     * Recursively divides two integers.
     *
     * @param num1 the first integer
     * @param num2 the second integer
     * @return the quotient of the two integers
     */
    public int recursiveDiv(final int num1, final int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        if (num1 < num2) {
            return 0;
        } else {
            return 1 + this.recursiveDiv(num1 - num2, num2);
        }
    }

    /**
     * Checks if a number is even.
     *
     * @param num the integer to check
     * @return true if the number is even, false otherwise
     */
    public boolean isEven(final int num) {
        logger.info("Checking if {} is even", num);
        return (num % 2 == 0);
    }

    /**
     * Checks if a number is odd.
     *
     * @param num the integer to check
     * @return true if the number is odd, false otherwise
     */
    public boolean isOdd(final int num) {
        logger.info("Checking if {} is odd", num);
        return (num % 2 != 0);
    }

    /**
     * Main method to demonstrate the functionality of the Calculator class.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        final Calculator calculator = new Calculator();
        final int num1 = 5;
        final int num2 = 3;
        System.out.println("Add: " + calculator.add(num1, num2));
        System.out.println("Subtract: " + calculator.sub(num1, num2));
        System.out.println("Multiply: " + calculator.multiply(num1, num2));
        System.out.println("Divide: " + calculator.divide(num1, num2));
        System.out.println("Square: " + calculator.square(num1));
        System.out.println("Factorial: " + calculator.factorial(num1));
        System.out.println("Recursive Add: "
            + calculator.recursiveAdd(num1, num2));
        System.out.println("Recursive Subtract: "
            + calculator.recursiveSub(num1, num2));
        System.out.println("Recursive Multiply: "
            + calculator.recursiveMultiply(num1, num2));
        System.out.println("Recursive Divide: "
            + calculator.recursiveDiv(num1, num2));
        System.out.println("Is Even: " + calculator.isEven(num1));
        System.out.println("Is Odd: " + calculator.isOdd(num1));
    }
}
