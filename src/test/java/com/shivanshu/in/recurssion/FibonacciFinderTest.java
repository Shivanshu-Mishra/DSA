package com.shivanshu.in.recurssion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciFinderTest {
    private FibonacciFinder fibonacciFinder;

    @Before
    public void setup() {
        fibonacciFinder = new FibonacciFinder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFibonacciNegativePosition() {
        fibonacciFinder.getFibonacci(-1);
    }

    @Test
    public void testFibonacciInitialPostion() {
        Assert.assertTrue("Fibonacci number at position 1 is 0", fibonacciFinder.getFibonacci(1) == 0);
        Assert.assertTrue("Fibonacci number at position 2 is 1", fibonacciFinder.getFibonacci(2) == 1);
    }

    @Test
    public void testFibonacci() {
        Assert.assertTrue("Fibonacci at position 7 is 8", fibonacciFinder.getFibonacci(7) == 8);
        Assert.assertTrue("Fibonacci at 29 is 317811",fibonacciFinder.getFibonacci(29)==317811);
    }
}
