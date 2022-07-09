package com.shivanshu.in.datastructure.logical.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayBasedStackTest {

    @Test
    public void testIsEmpty() {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(10);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull() throws StackException {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(3);
        assertFalse(stack.isFull());
        stack.push(1);
        assertFalse(stack.isFull());
        stack.push(2);
        assertFalse(stack.isFull());
        stack.push(3);
        assertTrue(stack.isFull());
    }

    @Test(expected = StackException.class)
    public void testStackOverFlow() throws StackException {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void testStackPeek() throws StackException {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(3 == stack.peek());
    }

    @Test
    public void testStackPop() throws StackException {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(3);
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        assertTrue(stack.pop()==3);
        assertTrue(stack.pop()==2);
        assertTrue(stack.pop()==1);
        stack.push(10);
        assertTrue(stack.pop()==10);
    }

    @Test(expected = StackException.class)
    public void testStackUnderFlow() throws StackException {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(1);
        stack.push(1);
        assertTrue(stack.pop()==1);
        stack.pop();

    }

    @Test
    public void testDeleteStack() throws StackException {
        ArrayBasedStack<Integer> stack = new ArrayBasedStack<>(1);
        stack.push(100);
        stack.deleteStack();
        assertTrue(stack.isEmpty());
    }
}
