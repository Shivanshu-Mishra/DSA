package com.shivanshu.in.datastructure.logical.queue;

public class QueueException extends Exception {

    public QueueException(String message){
        super(message);
    }

    public QueueException(String message,Throwable throwable){
        super(message,throwable);
    }
}
