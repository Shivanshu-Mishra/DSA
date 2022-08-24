package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList<E> {

    public List<Node<E>> split(Node<E> head){
        Node fastptr=head,slowptr=head;
        List<Node<E>> heads=new ArrayList<>();
        heads.add(head);
        while(!fastptr.getNextNode().equals(head) && !fastptr.getNextNode().getNextNode().equals(head)){
            fastptr=fastptr.getNextNode().getNextNode();
            slowptr=slowptr.getNextNode();
        }
        heads.add(slowptr.getNextNode());
        return heads;
    }
}
