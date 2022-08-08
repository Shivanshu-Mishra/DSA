package com.shivanshu.in.madeeasy.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

public class StackImpl<E> {
    private LinkedList<E> list;
    private int capacity;
    private int numOfElements;

    public StackImpl(int capacity){
        list=new LinkedList<E>();
        this.capacity=capacity;
        numOfElements=0;
    }

    public void push(E element){
        if(numOfElements==capacity){
            throw new StackException("Overflow");
        }
        list.addLast(element);
        numOfElements++;
    }
    public E pop() throws StackException {
        if(numOfElements==0){
            throw new StackException("Underflow");
        }
        numOfElements--;
        return list.removeLast();
    }

    public boolean isEmpty(){
        return numOfElements==0;
    }

    public boolean isFull(){
        return numOfElements==capacity;
    }

    public int search(E searchElement){
        for(int i=0;i<numOfElements;i++){
            if(list.get(i)==searchElement){
                return 1;
            }
        }
        return 0;
    }
}

/**
 * {@code StackException} is type unchecked exception
 * which occurs during runtime
 */
class StackException extends RuntimeException{
    public StackException(String message){
        super(message);
    }
}
