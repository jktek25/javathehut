package com.jktek25.app;

public class Calculator {
 
    public int add(int num1, int num2) {
        return (num1 + num2);
    }

    public int sub(int num1, int num2) {
        return (num1 - num2);
    }

    public int recursiveAdd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else if (num2 > 0) {
            return this.recursiveAdd(num1 + 1, num2 - 1);
        } else if (num2 < 0) {
            return this.recursiveAdd(num1 - 1, num2 + 1);
        } else
        {
            throw new Error("Unexpected and unhandled case");
        }
    }

    public int recursiveSub(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else if (num2 > 0) {
            return this.recursiveSub(num1 - 1, num2 - 1);
        } else if (num2 < 0) {
            return this.recursiveSub(num1 + 1, num2 + 1);
        } else
        {
            throw new Error("Unexpected and unhandled case");
        }
    }

}
