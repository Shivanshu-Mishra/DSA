package com.shivanshu.in.recurssion;

public class FibonacciFinder {

    public int getFibonacci(int position) {
        if (position < 1) {
            throw new IllegalArgumentException("Please provide position greater than 0 " + position);
        } else if (position == 1 || position == 2) {
            return position - 1;
        } else {
            return getFibonacci(position - 1) + getFibonacci(position - 2);
        }
    }

    /*private int fibonacci(int position){
        return fibonacci(position-1)-fibonacci(position-2);
    }*/
}
