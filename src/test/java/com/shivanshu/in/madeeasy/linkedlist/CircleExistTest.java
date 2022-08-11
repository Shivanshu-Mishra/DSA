package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.FloydCycleFindingSolution;
import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;
import com.shivanshu.in.madeeasy.linkedlist.circleexist.StoreNodeSolution;
import org.junit.Assert;
import org.junit.Test;

public class CircleExistTest {

    @Test
    public void testLinkedListWithCircle(){
        StoreNodeSolution solution1=new StoreNodeSolution();
        FloydCycleFindingSolution solution2=new FloydCycleFindingSolution();
        Node<Integer> node1=new Node<>(1,null);
        Node<Integer> node2=new Node<>(2,node1);
        Node<Integer> node3=new Node<>(3,node2);
        Node<Integer> node4=new Node<>(4,node3);
        node1.setNextNode(node3);
        Assert.assertTrue(solution1.isCircleExist(node4));
        solution2.isCircleExist(node4);
        //Assert.assertTrue(solution2.isCircleExist(node1));
    }

    @Test
    public void testLinkedListStraight(){
        StoreNodeSolution solution1=new StoreNodeSolution();
        FloydCycleFindingSolution solution2=new FloydCycleFindingSolution();
        Node<Integer> node1=new Node<>(1,null);
        Node<Integer> node2=new Node<>(2,node1);
        Node<Integer> node3=new Node<>(3,node2);
        Node<Integer> node4=new Node<>(4,node3);
        Assert.assertFalse(solution1.isCircleExist(node4));
        Assert.assertFalse(solution2.isCircleExist(node4));
    }
}
