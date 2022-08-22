package com.shivanshu.in.madeeasy.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class MergeSortedLinkedListTest {
    private MergeSortedLinkedList msll;

    @Before
    public void setup() {

        msll = new MergeSortedLinkedList();
    }


    @Test
    public void mergeEqualSizeListTest() {
        LinkedList list1;
        LinkedList list2;
        LinkedList expectedMergeList;
        list1 = new LinkedList();
        list2 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list2.add(2);
        list2.add(4);
        list2.add(6);
        expectedMergeList = new LinkedList();
        expectedMergeList.add(1);
        expectedMergeList.add(2);
        expectedMergeList.add(3);
        expectedMergeList.add(4);
        expectedMergeList.add(5);
        expectedMergeList.add(6);
        LinkedList originalMergeList=msll.iterativeMerge(list1, list2);
        Assert.assertEquals(expectedMergeList,originalMergeList);
    }

    @Test
    public void mergeEqualSizeListTest002() {
        LinkedList list1;
        LinkedList list2;
        LinkedList expectedMergeList;
        list1 = new LinkedList();
        list2 = new LinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        expectedMergeList = new LinkedList();
        expectedMergeList.add(1);
        expectedMergeList.add(2);
        expectedMergeList.add(3);
        expectedMergeList.add(4);
        expectedMergeList.add(5);
        expectedMergeList.add(6);
        LinkedList originalMergeList=msll.iterativeMerge(list1, list2);
        Assert.assertEquals(expectedMergeList,originalMergeList);
    }

    @Test
    public void mergeBiggerListWithSmallerListTest() {
        LinkedList list1;
        LinkedList list2;
        LinkedList expectedMergeList;
        list1 = new LinkedList();
        list2 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(9);
        list2.add(2);
        list2.add(4);
        list2.add(6);
        expectedMergeList = new LinkedList();
        expectedMergeList.add(1);
        expectedMergeList.add(2);
        expectedMergeList.add(3);
        expectedMergeList.add(4);
        expectedMergeList.add(5);
        expectedMergeList.add(6);
        expectedMergeList.add(9);
        LinkedList originalMergeList=msll.iterativeMerge(list1, list2);
        Assert.assertEquals(expectedMergeList,originalMergeList);
    }

    @Test
    public void mergeSmallerListWithBiggerListTest() {
        LinkedList list1;
        LinkedList list2;
        LinkedList expectedMergeList;
        list1 = new LinkedList();
        list2 = new LinkedList();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(9);
        expectedMergeList = new LinkedList();
        expectedMergeList.add(1);
        expectedMergeList.add(2);
        expectedMergeList.add(3);
        expectedMergeList.add(4);
        expectedMergeList.add(5);
        expectedMergeList.add(6);
        expectedMergeList.add(9);
        LinkedList originalMergeList=msll.iterativeMerge(list1, list2);
        Assert.assertEquals(expectedMergeList,originalMergeList);
    }

}
