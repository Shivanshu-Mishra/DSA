package com.shivanshu.in.datastructure.logical.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListBasedStackTest {
    @Test
    public void testIsEmpty() {
        LinkedListBasedStack<Integer> stack = new LinkedListBasedStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIsFull() throws StackException {
        LinkedListBasedStack<Integer> stack = new LinkedListBasedStack<>();
        stack.isFull();
    }

    @Test
    public void testStackPeek() throws StackException {
        LinkedListBasedStack<Integer> stack = new LinkedListBasedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(3 == stack.peek());
    }

    @Test
    public void testStackPop() throws StackException {
        LinkedListBasedStack<Integer> stack = new LinkedListBasedStack<>();
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        assertTrue(stack.pop() == 3);
        assertTrue(stack.pop() == 2);
        assertTrue(stack.pop() == 1);
        stack.push(10);
        assertTrue(stack.pop() == 10);
    }

    @Test(expected = StackException.class)
    public void testStackUnderFlow() throws StackException {
        LinkedListBasedStack<Integer> stack = new LinkedListBasedStack<>();
        stack.push(1);
        assertTrue(stack.pop() == 1);
        stack.pop();

    }

    @Test
    public void testDeleteStack() throws StackException {
        LinkedListBasedStack<Integer> stack = new LinkedListBasedStack<>();
        stack.push(100);
        stack.deleteStack();
        assertTrue(stack.isEmpty());
    }
}
