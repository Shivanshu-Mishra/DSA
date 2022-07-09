package com.shivanshu.in.datastructure.logical.stack;

public interface Stack<T> {

    void push(T element) throws StackException;
    T pop() throws StackException;
    T peek();
    boolean isEmpty();
    boolean isFull();
    void deleteStack();
}
