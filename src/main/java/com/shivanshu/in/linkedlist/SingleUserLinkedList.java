package com.shivanshu.in.linkedlist;

public class SingleUserLinkedList<T> implements UserLinkedList<T> {
    private Node head;
    private Node tail;
    private int numberOfElement=0;

    public void insertFirst(T value) {

    }

    public void insertLast(T value) {

    }

    public void insert(T element, int position) {

    }

    public void insert(T element) {
        Node newNode = new Node(element, null);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            numberOfElement++;
            return;
        }

        Node node = this.head;
        while (node.next != null) {
            node.next = newNode;
            tail = newNode;
        }
    }

    public boolean contain(T element) {
        if (this.head == null || this.tail == null) {
            return false;
        }

        Node node = this.head;
        while (node != null) {
            if (node.element.equals(element)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void delete(T value) {

    }

    public void deleteLast() {

    }

    public void deleteFirst() {

    }

    public void delete(int position) {

    }

    public void destroy() {

    }

    public int size() {
        return numberOfElement;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public T get(int position) {
        return null;
    }

    public static class Node<T> {
        T element;
        Node next;

        Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }
}
