package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * M=Size of list1
 * N=Size of list2
 */
public class LinkedListMergePointTest {
    private LinkedListMergePoint llmp;
    private Node list1Node1;
    private Node list1Node2;
    private Node list1Node3;
    private Node list2Node1;
    private Node list2Node2;
    private Node list2Node3;
    private Node commonNode1;
    private Node commonNode2;

    @Before
    public void setup() {
        llmp = new LinkedListMergePoint();
        list1Node1 = new Node(1, null);
        list1Node2 = new Node(2, null);
        list1Node3 = new Node(3, null);
        list2Node1 = new Node(4, null);
        list2Node2 = new Node(5, null);
        list2Node3 = new Node(6, null);
        commonNode1 = new Node(7, null);
        commonNode2 = new Node(8, null);
        commonNode1.setNextNode(commonNode2);

    }

    /**
     * M=N and both list meet at point P
     */
    @Test
    public void testMergePoint10() {
        list1Node1.setNextNode(list1Node2);
        list1Node2.setNextNode(list1Node3);
        list1Node3.setNextNode(commonNode1);
        list2Node1.setNextNode(list2Node2);
        list2Node2.setNextNode(list2Node3);
        list2Node3.setNextNode(commonNode1);
        Node mergePoint=llmp.mergePoint(list1Node1,list2Node1);
        Assert.assertEquals(commonNode1,mergePoint);

    }

    /**
     * M>N and both list meet at point M
     */
    @Test
    public void testMergePoint11() {
        list1Node1.setNextNode(list1Node2);
        list1Node2.setNextNode(list1Node3);
        list1Node3.setNextNode(commonNode1);
        list2Node1.setNextNode(list2Node2);
        list2Node2.setNextNode(commonNode1);
        Node mergePoint=llmp.mergePoint(list1Node1,list2Node1);
        Assert.assertEquals(commonNode1,mergePoint);
    }

    /**
     * M<N and both list meet at point P
     */
    @Test
    public void testMergePoint20() {
        list1Node1.setNextNode(list1Node2);
        list1Node2.setNextNode(commonNode1);
        list2Node1.setNextNode(list2Node2);
        list2Node2.setNextNode(list2Node3);
        list2Node3.setNextNode(commonNode1);
        Node mergePoint=llmp.mergePoint(list1Node1,list2Node1);
        Assert.assertEquals(commonNode1,mergePoint);
    }
}
