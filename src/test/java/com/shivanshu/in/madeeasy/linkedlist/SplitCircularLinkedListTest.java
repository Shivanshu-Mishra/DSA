package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SplitCircularLinkedListTest {

    Node<Integer> node4 = new Node(4, null);
    private CircularLinkedList<Integer> cll;

    @Before
    public void setup() {
        cll = new CircularLinkedList<>();
    }

    @Test
    public void testEvenNode() {
        Node<Integer> node1 = new Node(1, null);
        Node<Integer> node2 = new Node(2, null);
        Node<Integer> node3 = new Node(3, null);
        Node<Integer> node4 = new Node(4, null);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node1);
        List<Node<Integer>> heads = cll.split(node1);
        Node<Integer> list1 = heads.get(0);
        Node<Integer> list2 = heads.get(1);
        Assert.assertEquals(list1.getNextNode(), node2);
        Assert.assertEquals(list2, node3);
    }

    @Test
    public void testOddNode() {
        Node<Integer> node1 = new Node(1, null);
        Node<Integer> node2 = new Node(2, null);
        Node<Integer> node3 = new Node(3, null);
        Node<Integer> node4 = new Node(4, null);
        Node<Integer> node5 = new Node(5, null);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node1);
        List<Node<Integer>> heads = cll.split(node1);
        Node<Integer> list1 = heads.get(0);
        Node<Integer> list2 = heads.get(1);
        Assert.assertEquals(list1.getNextNode(), node2);
        Assert.assertEquals(list2, node4);
    }

    @Test
    public void testSingleNode() {
        Node<Integer> node1 = new Node(1, null);
        node1.setNextNode(node1);
        List<Node<Integer>> heads = cll.split(node1);
        Assert.assertEquals(node1, heads.get(0));
        Assert.assertEquals(node1, heads.get(1));
    }
}

