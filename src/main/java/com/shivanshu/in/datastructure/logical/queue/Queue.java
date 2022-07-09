package com.shivanshu.in.datastructure.logical.queue;

public interface Queue<T> {
    void enque(T element) throws QueueException;
    T deque();
    T peek();
    boolean isEmpty();
    boolean isFull();
    void destroy();
}
