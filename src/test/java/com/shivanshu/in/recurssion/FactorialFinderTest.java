package com.shivanshu.in.recurssion;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactorialFinderTest {
    private FactorialFinder factorialFinder;

    @Before
    public void setUp() {
        factorialFinder = new FactorialFinder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        factorialFinder.getFactorial(-1);
    }

    @Test
    public void testFactorial() {
        Assert.assertTrue("Factorial of 1 is 1", factorialFinder.getFactorial(1) == 1);
        Assert.assertTrue("Factorial of 5 is 120",factorialFinder.getFactorial(5)==120);
        Assert.assertTrue("Factorial of 10 is 3628800",factorialFinder.getFactorial(10)==3628800);
    }

}
