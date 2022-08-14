package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;
import com.shivanshu.in.madeeasy.linkedlist.circleexist.ReverseLinkedRecursively;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListIterativelyTest {

    @Test
    public void testReverseLinkedList(){
        ReverseLinkedListIteratively rll=new ReverseLinkedListIteratively();
        Node<Integer> node1=new Node<>(1,null);
        Node<Integer> node2=new Node<>(2,node1);
        Node<Integer> node3=new Node<>(3,node2);
        Node<Integer> head=new Node<>(4,node3);
        System.out.println("Before");
        rll.print(head);
        Node<Integer> reverseHead=rll.reverse(head);
        System.out.println("After");
        rll.print(reverseHead);
        Assert.assertEquals(node1,reverseHead);
        Node<Integer> reverseNode2=reverseHead.getNextNode();
        Assert.assertEquals(node2,reverseNode2);
        Node<Integer> reverseNode3=reverseNode2.getNextNode();
        Assert.assertEquals(node3,reverseNode3);
        Node<Integer> reverseNode4=reverseNode3.getNextNode();
        Assert.assertEquals(head,reverseNode4);
        //rll.print(reverseNode1);
    }

    @Test
    public void testReverseLinkedRecursively(){
        ReverseLinkedRecursively reverseLinkedRecursively=new ReverseLinkedRecursively();
        Node<Integer> node1=new Node<>(1,null);
        Node<Integer> node2=new Node<>(2,node1);
        Node<Integer> node3=new Node<>(3,node2);
        Node<Integer> head=new Node<>(4,node3);
        System.out.println("Before");
        reverseLinkedRecursively.print(head);
        Node<Integer> reverseHead=reverseLinkedRecursively.reverse(head);
        System.out.println("After");
        reverseLinkedRecursively.print(reverseHead);
        Assert.assertEquals(node1,reverseHead);
        Node<Integer> reverseNode2=reverseHead.getNextNode();
        Assert.assertEquals(node2,reverseNode2);
        Node<Integer> reverseNode3=reverseNode2.getNextNode();
        Assert.assertEquals(node3,reverseNode3);
        Node<Integer> reverseNode4=reverseNode3.getNextNode();
        Assert.assertEquals(head,reverseNode4);
        //rll.print(reverseNode1);
    }
}
