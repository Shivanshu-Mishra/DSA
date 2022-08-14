package com.shivanshu.in.madeeasy.linkedlist.circleexist;

public class ReverseLinkedRecursively {
    public Node reverse(Node node){
        return updatePointers(null,node);
    }

    private Node updatePointers(Node previous,Node current){
        if(current==null)
            return previous;
        Node head=updatePointers(current,current.getNextNode());
        current.setNextNode(previous);
        return head;
    }

    public void print(Node node){
        int pos = 1;
        while (node != null) {
            System.out.printf("Node%s:%s\n", pos, node.getData().toString());
            node = node.getNextNode();
            pos++;
        }
    }
}
