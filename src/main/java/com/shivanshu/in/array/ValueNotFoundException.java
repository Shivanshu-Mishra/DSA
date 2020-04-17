package com.shivanshu.in.array;

public class ValueNotFoundException extends Exception {

    public ValueNotFoundException(String message) {
        super(message);
    }

    public ValueNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
