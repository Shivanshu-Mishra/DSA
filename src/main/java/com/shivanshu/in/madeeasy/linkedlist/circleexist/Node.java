package com.shivanshu.in.madeeasy.linkedlist.circleexist;

public class Node<E> {
    private E data;
    private Node<E> nextNode;

    public Node(E data,Node<E> nextNode){
        this.data=data;
        this.nextNode=nextNode;
    }

    public void setNextNode(Node<E> nextNode){
        this.nextNode=nextNode;
    }

    public E getData(){
        return data;
    }

    public Node<E> getNextNode(){
        return nextNode;
    }
}
