package com.shivanshu.in.datastructure.physical.linkedlist;

public class EmptyLinkedListException extends Exception {
     public EmptyLinkedListException(String message){
         super(message);
     }

     public EmptyLinkedListException(String message,Throwable cause){
         super(message,cause);
     }
}
