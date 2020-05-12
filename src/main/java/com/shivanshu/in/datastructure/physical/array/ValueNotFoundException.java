package com.shivanshu.in.datastructure.physical.array;

public class ValueNotFoundException extends Exception {

    public ValueNotFoundException(String message) {
        super(message);
    }

    public ValueNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
