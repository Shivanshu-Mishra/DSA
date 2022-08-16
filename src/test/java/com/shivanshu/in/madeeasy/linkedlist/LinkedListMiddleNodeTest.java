package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListMiddleNodeTest {
    Node<Integer> node1;
    Node<Integer> node2;
    Node<Integer> node3;
    Node<Integer> node4;
    Node<Integer> node5;
    Node<Integer> node6;

    @Before
    public void setup() {
        node1 = new Node<>(1, null);
        node2 = new Node<>(2, null);
        node3 = new Node<>(3, null);
        node4 = new Node<>(4, null);
        node5 = new Node<>(5, null);
        node6 = new Node<>(6, null);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
    }

    @Test
    public void testMiddleOddNumberOfNodes() {
        LinkedListMiddleNode llmp = new LinkedListMiddleNode();
        Node middleNode = llmp.getMiddleNode(node1);
        Assert.assertEquals(middleNode, node3);
    }

    @Test
    public void testMiddleEvenNumberOfNodes() {
        node5.setNextNode(node6);
        LinkedListMiddleNode llmp = new LinkedListMiddleNode();
        Node middleNode = llmp.getMiddleNode(node1);
        System.out.println(middleNode.getData());
    }

}
