package com.shivanshu.in.madeeasy.linkedlist;

import com.shivanshu.in.madeeasy.linkedlist.circleexist.Node;

/**
 * Iterative Version
 * Algortihm to reverse Single linked list
 */
public class ReverseLinkedListIteratively {
    public Node reverse(Node head) {
        Node current = head;
        Node next = current.getNextNode();
        Node previous = null;
        while (current != null) {
            current.setNextNode(previous);
            previous = current;
            current = next;
            if (current != null)
                next = current.getNextNode();
        }
        return previous;
    }

    public void print(Node node) {
        int pos = 1;
        while (node != null) {
            System.out.printf("Node%s:%s\n", pos, node.getData().toString());
            node = node.getNextNode();
            pos++;
        }

    }
}
