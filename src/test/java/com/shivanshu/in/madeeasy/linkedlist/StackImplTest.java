package com.shivanshu.in.madeeasy.linkedlist;

import org.junit.Assert;
import org.junit.Test;


public class StackImplTest {

    @Test
    public void testInitialization(){
        StackImpl<Integer> stack=new StackImpl<>(5);
        Assert.assertTrue(stack.isEmpty());
        Assert.assertFalse(stack.isFull());
    }

    @Test
    public void testPush(){
        StackImpl<String> stack=new StackImpl<>(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
    }

    @Test(expected = StackException.class)
    public void testOverFlow(){
        StackImpl<String> stack=new StackImpl<>(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
    }

    @Test
    public void testPop(){
        StackImpl<Integer> stack=new StackImpl<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertTrue(stack.pop()==4);
        Assert.assertTrue(stack.pop()==3);
    }

    @Test(expected = StackException.class)
    public void testUnderFlow(){
        StackImpl<Integer> stack=new StackImpl<>(5);
        stack.pop();
    }

    @Test
    public void testEmpty(){
        StackImpl<Integer> stack=new StackImpl<>(5);
        Assert.assertTrue(stack.isEmpty());
        stack.push(30);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void testFull(){
        StackImpl<Integer> stack=new StackImpl<>(2);
        stack.push(1);
        stack.push(2);
        Assert.assertTrue(stack.isFull());
        stack.pop();
        stack.pop();
        Assert.assertFalse(stack.isFull());
    }

    @Test
    public void testSearch(){
        StackImpl<Integer> stack=new StackImpl<>(2);
        stack.push(1);
        stack.push(2);
        Assert.assertTrue(stack.search(2)==1);
        Assert.assertTrue(stack.search(10)==0);
    }

    @Test
    public void testRepetitiveOperation(){
        StackImpl<Integer> stack=new StackImpl<>(2);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        Assert.assertTrue(stack.search(3)==1);
    }
}
