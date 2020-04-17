package com.shivanshu.in.recurssion;

public class FactorialFinder {

    public double getFactorial(int number) {
        return factorial(number);
    }

    private double factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial of negative " + number + " not possible");
        } else if (number == 1) {
            return number;
        } else {
            return number * factorial(number - 1);
        }
    }
}
