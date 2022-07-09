package com.shivanshu.in.datastructure.logical.queue;

public class ArrayBasedQueue implements Queue<Integer> {
    private int[] queue;
    int top = -1;
    int bottom = -1;

    public ArrayBasedQueue(int size) {
        queue = new int[size];
    }

    @Override
    public void enque(Integer element) throws QueueException {
        top++;
        if (bottom == -1) {
            bottom++;
        }
        if (isFull()) {
            throw new QueueException("Overflow.No element can be added in queue");
        }
        queue[top] = element;
    }

    @Override
    public Integer deque() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == queue.length;
    }

    @Override
    public void destroy() {

    }
}
