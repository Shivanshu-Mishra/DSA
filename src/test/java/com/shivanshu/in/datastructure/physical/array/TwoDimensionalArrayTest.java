package com.shivanshu.in.datastructure.physical.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoDimensionalArrayTest {
    private TwoDimensionalArray tdaTest;

    @Before
    public void setup() {
        tdaTest = new TwoDimensionalArray(5, 3);
        tdaTest.insert(0, 0, 0);
        tdaTest.insert(0, 1, 10);
        tdaTest.insert(0, 2, 20);
    }

    @Test
    public void testTraverse() {
        String expectedString = "0,10,20";
        String resultString = tdaTest.traverse(",");
        System.out.println(resultString);
        Assert.assertTrue(expectedString.equals(resultString));
    }

    @Test
    public void testInsert001() {
        int tdaSizeBeforeInsertion = tdaTest.size();
        tdaTest.insert(1, 0, 37);
        Assert.assertTrue(tdaTest.size() - tdaSizeBeforeInsertion == 1);
    }

    @Test
    public void testDeletion001() throws ValueNotFoundException {
        tdaTest.insert(1, 1, 94);
        int tdaSizeBeforeDeletion = tdaTest.size();
        tdaTest.delete(94);
        Assert.assertTrue(tdaSizeBeforeDeletion - tdaTest.size() == 1);
    }

    @Test
    public void testSearch() {
        TwoDimensionalArray.Location location = tdaTest.search(20);
        Assert.assertTrue(location.getRow() == 0 && location.getColumn() == 2);
    }

    @Test
    public void testAccess(){
        Assert.assertTrue(tdaTest.access(0,1)==10);
        Assert.assertFalse(tdaTest.access(0,0)==9);
    }
}
