package com.shivanshu.in.datastructure.physical.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingleDimensionalArrayTest {
    private SingleDimensionalArray array;

    @Before
    public void setup() {
        array = new SingleDimensionalArray(10);
        array.insert(0, 0);
        array.insert(1, 10);
        array.insert(2, 20);
        array.insert(3, 60);
    }

    @Test
    public void testValueInsert() {
        Assert.assertFalse("Insertion to to occupied position should not be possible", array.insert(0, 12));
        Assert.assertTrue("Insertion of new value into array not possible", array.insert(4, 12));
    }

    @Test
    public void testValueSearch() {
        Assert.assertTrue("Value 10 should be present at location 1", array.search(10) == 1);
        Assert.assertFalse("Value 900 should not be present in array", array.search(900) != -1);
    }

    @Test
    public void testArrayAccess() {
        Assert.assertTrue(array.access(2) == 20);
        Assert.assertTrue(array.access(3) == 60);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayAccessIllegalCell001() {
        array.access(100);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayAccessIllegalCell002() {
        array.access(-1);
    }

    @Test
    public void testArrayTraversal() {
        String expectedString = "0,10,20,60";
        String resultString = array.traverse(",");
        Assert.assertTrue(expectedString.equals(resultString));
    }

    @Test
    public void testArrayValueDeletion() throws ValueNotFoundException {
        array.insert(array.size(), 69);
        array.delete(69);
        Assert.assertTrue(array.search(69) == -1);
    }

    @Test(expected = ValueNotFoundException.class)
    public void testArrayNonExistingValueDeletion() throws ValueNotFoundException {
        array.delete(1000);
    }

    @Test
    public void testModifiedArraySizeDeletion() throws ValueNotFoundException {
        array.insert(array.size(), 989);
        int arraySizeBeforeDeletion=array.size();
        array.delete(989);
        int arraySizeAfterDeletion=array.size();
        Assert.assertTrue(arraySizeBeforeDeletion-arraySizeAfterDeletion==1);
        Assert.assertTrue(array.access(arraySizeBeforeDeletion) == Integer.MIN_VALUE);
    }

    @Test
    public void testArraySize() throws ValueNotFoundException {
        Assert.assertTrue(array.size() == 4);
        array.insert(array.size(), 98);
        Assert.assertTrue(array.size() == 5);
        array.delete(98);
        Assert.assertTrue(array.size() == 4);
    }


}
