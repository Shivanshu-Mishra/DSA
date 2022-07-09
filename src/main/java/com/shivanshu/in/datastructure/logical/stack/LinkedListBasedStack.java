package com.shivanshu.in.datastructure.logical.stack;

import com.shivanshu.in.datastructure.physical.linkedlist.EmptyLinkedListException;
import com.shivanshu.in.datastructure.physical.linkedlist.SingleUserLinkedList;

/**
 * LinkedList based stack implementation.
 *
 * @param <T>
 */
public class LinkedListBasedStack<T> implements Stack<T> {
    private SingleUserLinkedList<T> linkedList;

    public LinkedListBasedStack() {
        linkedList = new SingleUserLinkedList<T>();
    }

    /**
     * Push an element in last of stack
     *
     * @param element - Element to push
     *                <p>
     *                Time complexity - O(1)
     *                Space complexity - O(1)
     * @throws StackException
     */
    @Override
    public void push(T element) throws StackException {
        linkedList.insertLast(element);
    }

    /**
     * Pop last element from stack
     * <p>
     * Time complexity - O(N)
     * Space complexity - O(1)
     *
     * @return T - Popped out element
     * @throws StackException
     */
    @Override
    public T pop() throws StackException {
        T element;
        try {
            if (linkedList.size() == 0) {
                throw new StackException("Underflow.Cannot pop out more element.");
            }
            element = linkedList.getLast();
            linkedList.deleteLast();
        } catch (EmptyLinkedListException e) {
            throw new StackException("Problem in popping out element from stack", e);
        }
        return element;
    }

    /**
     * Peek last element from stack
     * <p>
     * Time complexity - O(1)
     * Space complexity - O(1)
     *
     * @return T - Popped out element
     * @throws StackException
     */
    @Override
    public T peek() {
        try {
            return linkedList.getLast();
        } catch (EmptyLinkedListException e) {
            return null;
        }
    }

    /**
     * Check if stack is empty.
     * <p>
     * Time complexity - O(1)
     * Space complexity - O(1)
     *
     * @return true if stack is empty
     */
    @Override
    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("LinkedList based stack cannot be full");
    }

    /**
     * Delete an entire stack.
     *
     * Time complexity - O(1)
     * Space complexity - O(1)
     */
    @Override
    public void deleteStack() {
        linkedList = new SingleUserLinkedList<T>();
    }
}
