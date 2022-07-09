package com.shivanshu.in.datastructure.logical.stack;

import com.shivanshu.in.datastructure.physical.array.SingleDimensionalArray;
import com.shivanshu.in.datastructure.physical.array.ValueNotFoundException;

/**
 * Array based stack implementation to store integer values.
 *
 * @param <Integer>
 */
public class ArrayBasedStack<Integer> implements Stack<java.lang.Integer> {
    private SingleDimensionalArray array;
    private int top = -1;
    private int bottom = -1;
    private int stackSize = 0;
    private static final int MIN_SIZE = 0;

    /**
     * Constructor
     * Time Complexity - O(N)
     * Space Complexity - O(N)
     *
     * @param size - Size of stack
     */
    public ArrayBasedStack(int size) {
        array = new SingleDimensionalArray(size);
        stackSize = size;
    }

    /**
     * Push an element in Stack
     * <p>
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param element - to be pushed
     * @throws StackException
     */
    @Override
    public void push(java.lang.Integer element) throws StackException {
        top++;
        if (top == stackSize) {
            throw new StackException("Overflow. No new element can be inserted into stack");
        }
        array.insert(top, element);
        if (bottom == -1) {
            bottom++;
        }
    }

    /**
     * Pop an element in Stack
     * <p>
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @throws StackException
     */
    @Override
    public java.lang.Integer pop() throws StackException {
        if (top < MIN_SIZE || bottom < MIN_SIZE) {
            throw new StackException("Underflow. No element can be removed from stack.");
        }
        int value = array.access(top);
        try {
            array.delete(value);
        } catch (ValueNotFoundException e) {
            throw new StackException(value + " not found", e);
        }
        top--;
        if (top < MIN_SIZE) {
            bottom--;
        }
        return value;
    }

    /**
     * Peek an element in Stack
     * <p>
     * Time Complexity - O(1)
     * Space Complexity -  O(1)
     *
     * @return Integer - Last inserted element in Stack.
     */
    @Override
    public java.lang.Integer peek() {
        return array.access(top);
    }

    /**
     * Check whether Stack is empty or not.
     * <p>
     * Time Complexity - O(1)
     * Space Complexity -  O(1)
     *
     * @return true - If stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return top < MIN_SIZE && bottom < MIN_SIZE && array.size() == 0;
    }

    /**
     * Check whether Stack is full or not.
     * <p>
     * Time Complexity - O(1)
     * Space Complexity -  O(1)
     *
     * @return true - If stack is full.
     */
    @Override
    public boolean isFull() {
        return top == stackSize - 1;
    }

    /**
     * Delete stack.
     * <p>
     * Time Complexity - O(1)
     * Space Complexity -  O(1)
     */
    @Override
    public void deleteStack() {
        array = new SingleDimensionalArray(stackSize);
        top = -1;
        bottom = -1;
    }
}
