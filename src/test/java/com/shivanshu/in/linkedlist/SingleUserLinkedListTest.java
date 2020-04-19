package com.shivanshu.in.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class SingleUserLinkedListTest {
    private UserLinkedList testList;

    @Test
    public void testSizeFirstELement() {
        testList = new SingleUserLinkedList();
        testList.insert(10);
        Assert.assertTrue(testList.size() == 1);
    }

    @Test
    public void testSize(){

    }

//    @Test
//    public void testInsertFirst() {
//        linkedList.insert(10);
//        linkedList.insert("10");
//    }
}
