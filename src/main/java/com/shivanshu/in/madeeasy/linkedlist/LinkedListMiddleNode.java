package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;

/**
 * Middle of the linked list
 *
 * Algorithm work by moving 2 pointer, one double speed of another.
 */
public class LinkedListMiddleNode {
    Node fastPointer;
    Node slowPointer;

    public Node getMiddleNode(Node node) {
        fastPointer = node;
        slowPointer = node;
        while (fastPointer != null) {
            if (fastPointer.getNextNode() != null) {
                fastPointer = fastPointer.getNextNode().getNextNode();
                slowPointer = slowPointer.getNextNode();
            }else{
                break;
            }
        }
        return slowPointer;
    }
}
