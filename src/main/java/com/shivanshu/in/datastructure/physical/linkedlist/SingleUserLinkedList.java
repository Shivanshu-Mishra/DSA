package com.shivanshu.in.datastructure.physical.linkedlist;

import java.util.Iterator;

/**
 * Each node in list contain data and reference to next node. No node element contain reference to
 * previous node. Last node reference to null
 *
 * @param <T>
 */
public class SingleUserLinkedList<T> implements UserLinkedList<T>, Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int numberOfElement = 0;

    /**
     * Insert element at first position in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param value - element to be inserted
     */
    public void insertFirst(T value) {
        Node<T> newNode = null;
        if (this.head == null) {
            newNode = new Node<T>(value, null);
            this.tail = newNode;
        } else {
            newNode = new Node<T>(value, this.head.next);
        }
        this.head = newNode;
        numberOfElement++;
    }

    /**
     * Insert element at last position in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param value - element to be inserted
     */
    public void insertLast(T value) {
        Node<T> newNode = new Node<T>(value, null);
        if (this.tail != null) {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        if (this.head == null) {
            this.head = newNode;
        }
        numberOfElement++;
    }

    /**
     * Insert element at specified position in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @param position - in linked list where element need to be  inserted.
     * @param element  - to be inserted
     */
    public void insert(T element, int position) {
        if (position < 0 || position > size()) {
            throw new IndexOutOfBoundsException("Position to insert should be between 0 and " + size());
        }

        if (position == 0) {
            insertFirst(element);
        } else if (position == size()) {
            insertLast(element);
        } else {
            Node<T> node = this.head;
            for (int index = 1; index < position; index++) {
                node = node.next;
            }
            node.next = new Node<T>(element, node.next);
        }
    }

    /**
     * Insert element in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param element - to be inserted
     */
    public void insert(T element) {
        Node newNode = new Node(element, null);
        if (head == null) {
            head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        numberOfElement++;
    }

    /**
     * Check if element in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @param element - to be inserted
     * @return - true if element exist
     */
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

    /**
     * Delete element from LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @param value - to be deleted
     * @throw EmptyLinkedListException
     */
    public void delete(T value) throws EmptyLinkedListException {
        if (this.tail == null || this.head == null) {
            throw new EmptyLinkedListException("Cannot perform delete operation");
        }
        Node<T> node = this.head;
        if (node.element.equals(value)) {
            this.head = node.next;
            numberOfElement--;
            return;
        }
        while (node != this.tail) {
            if (node.next == null && node.element.equals(value)) {
                this.tail = null;
                break;
            }
            if (node.next.element.equals(value)) {
                node.next = node.next.next;
                numberOfElement--;
                break;
            }
            node = node.next;
        }
    }

    /**
     * Delete last element from LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @throw EmptyLinkedListException
     */
    public void deleteLast() throws EmptyLinkedListException {
        if (this.tail == null) {
            throw new EmptyLinkedListException("Cannot perform delete operation");
        }
        Node<T> node = this.head;

        while (node != this.tail) {
            if (node.next == tail) {
                node.next = null;
                this.tail = node;
                numberOfElement--;
                break;
            }
            node = node.next;
        }

        if(node==this.tail){
            this.head=null;
            this.tail=null;
            numberOfElement--;
        }
    }

    /**
     * Delete First element from LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @throw EmptyLinkedListException
     */
    public void deleteFirst() throws EmptyLinkedListException {
        if (this.head == null) {
            throw new EmptyLinkedListException("Cannot perform delete operation");
        }
        this.head = this.head.next;
        numberOfElement--;
    }

    /**
     * Delete element from specified position in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @throw EmptyLinkedListException
     */
    public void delete(int position) throws EmptyLinkedListException {
        if (position < 0 || position >= numberOfElement) {
            throw new IndexOutOfBoundsException(position + " cannot be deleted.");
        }

        if (position == 0) {
            deleteFirst();
        } else if (position == numberOfElement - 1) {
            deleteLast();
        } else {
            Node<T> node = this.head.next;
            int index = 1;
            while (index < position - 1) {
                node = node.next;
                index++;
            }
            node.next = node.next.next;
            numberOfElement--;
        }
    }

    /**
     * Destroy LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    public void destroy() {
        this.head = null;
        this.tail = null;
        numberOfElement = 0;
    }

    /**
     * Get  size of Linked List
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @return int - number of element in LinkedList
     */
    public int size() {
        return numberOfElement;
    }

    /**
     * Get first element of Linked List
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @return T - first element in linked list.
     */
    public T getFirst() throws EmptyLinkedListException {
        if (this.head != null)
            return this.head.element;
        throw new EmptyLinkedListException("LinkedList is empty");
    }

    /**
     * Get last element of Linked List
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @return T - last element in linked list.
     */
    public T getLast() throws EmptyLinkedListException {
        if (this.tail != null)
            return this.tail.element;
        throw new EmptyLinkedListException("LinkedList is empty");
    }

    /**
     * Get element at index in Linked List
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @return T - first element in linked list.
     */
    public T get(int index) throws EmptyLinkedListException {
        if (size() == 0) {
            throw new EmptyLinkedListException("LinkedList is empty");
        }

        if (index > numberOfElement - 1) {
            throw new IndexOutOfBoundsException("Maximum indexes in Linked list is " + (numberOfElement - 1));
        }

        int pos = 0;
        Node<T> node = this.head;
        while (pos != index) {
            node = node.next;
            pos++;
        }
        return node.element;
    }

    /**
     * @return - iterator to loop through elements in LinkedList
     * <p>
     * NOTE: LinkedList modification while traversal will give unpredictable output
     */
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator<T>(head);
    }

    class SingleLinkedListIterator<T> implements Iterator<T> {
        Node<T> head;
        Node<T> node;

        public SingleLinkedListIterator(Node<T> head) {
            this.head = head;
            this.node = head;
        }

        public boolean hasNext() {
            return this.node != null;
        }

        public T next() {
            T element = node.element;
            node = node.next;
            return element;
        }

        public void remove() {
            throw new UnsupportedOperationException("SingleUserLinkedList operation not permissible");
        }
    }

    /**
     * This class represent Node in Linked to store element of Type and reference
     * next node.
     *
     * @param <T>
     */
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
