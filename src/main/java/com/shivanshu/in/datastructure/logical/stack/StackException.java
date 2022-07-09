package com.shivanshu.in.datastructure.logical.stack;

public class StackException extends Exception {

    public StackException(String message){
        super(message);
    }

    public StackException(String message, Throwable t){
        super(message,t);
    }
}
