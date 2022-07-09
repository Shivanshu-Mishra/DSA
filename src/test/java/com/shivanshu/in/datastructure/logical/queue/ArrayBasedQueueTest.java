package com.shivanshu.in.datastructure.logical.queue;

import static org.junit.Assert.*;

import com.shivanshu.in.datastructure.logical.stack.StackException;
import org.junit.Test;

public class ArrayBasedQueueTest {

    @Test
    public void testCreateQueue(){
        ArrayBasedQueue queue=new ArrayBasedQueue(5);
        assertNotNull(queue);
    }

    @Test
    public void testEnque() throws QueueException {
        ArrayBasedQueue queue=new ArrayBasedQueue(2);
        queue.enque(10);
        queue.enque(20);
    }

    @Test(expected= StackException.class)
    public void testOverflow() throws QueueException {
        ArrayBasedQueue queue=new ArrayBasedQueue(2);
        queue.enque(10);
        queue.enque(20);
        queue.enque(30);
    }
}
