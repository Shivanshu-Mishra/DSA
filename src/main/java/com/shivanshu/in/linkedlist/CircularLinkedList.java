package com.shivanshu.in.linkedlist;

import java.util.Iterator;

import static com.shivanshu.in.linkedlist.SingleUserLinkedList.Node;

/**
 * Each node in list contain data and reference to next node. No node element contain reference to
 * previous node. Last node reference to First node in list and create a circle.
 *
 * @param <T>
 */
public class CircularLinkedList<T> implements UserLinkedList<T>, Iterable<T> {
    private int numberOfElement = 0;
    private T element;
    private Node<T> head;
    private Node<T> tail;

    /**
     * Insert element at first position in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param element - element to be inserted
     */
    public void insertFirst(T element) {
        Node<T> node;
        if (head == null) {
            node = new Node<T>(element, null);
            tail = node;
        } else {
            node = new Node<T>(element, head);
            tail.next = node;
        }
        head = node;
        numberOfElement++;
    }

    /**
     * Insert element at Last position in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param element - element to be inserted
     */
    public void insertLast(T element) {
        Node<T> node;
        if (tail != null) {
            node = new Node<T>(element, tail.next);
            tail.next = node;
        } else {
            node = new Node<T>(element, null);
            node.next = node;
            this.head = node;
        }
        tail = node;
        numberOfElement++;
    }

    /**
     * Insert element at specified position in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @param element - element to be inserted
     */
    public void insert(T element, int position) {
        if (position < 0 || position > size()) {
            throw new IndexOutOfBoundsException("ELement can be inserted at index from 0 to " + size());
        } else if (position == 0) {
            insertFirst(element);
        } else if (position == size()) {
            insertLast(element);
        } else {
            Node<T> node = head;
            for (int index = 0; index < position - 1; index++) {
                node = node.next;
            }
            Node<T> newNode = new Node<T>(element, node.next);
            node.next = newNode;
            numberOfElement++;
        }
    }

    public void insert(T element) {
        if (tail == null || head == null) {
            Node<T> newNode = new Node<T>(element, null);
            newNode.next = newNode;
            tail = newNode;
            head = newNode;
        } else {
            Node<T> newNode = new Node<T>(element, tail.next);
            tail.next = newNode;
            tail = newNode;
        }
        numberOfElement++;
    }

    /**
     * Check if an element exist in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @param element - element to search
     * @return true if element exist, false if Linked list is empty
     * or LinkedList does not exist.
     */
    public boolean contain(T element) {
        Node<T> node = head;
        for (int index = 0; index < size(); index++) {
            if (node.element.equals(element)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Delete an element in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     */
    public void delete(T element) throws EmptyLinkedListException {
        if (tail == null || head == null) {
            throw new EmptyLinkedListException("No element in Linked List to delete");
        }
        Node<T> node = head;
        for (int index = 0; index < size(); index++) {
            if (node.next.element.equals(element)) {
                if (index == 0) {
                    deleteFirst();
                } else if (index == size() - 1) {
                    deleteLast();
                } else {
                    node = node.next.next;
                    numberOfElement--;
                    break;
                }

            }
            node = node.next;
        }
    }

    /**
     * Delete Last element in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     */
    public void deleteLast() throws EmptyLinkedListException {
        if (tail == null) {
            throw new EmptyLinkedListException("No element in Linked List to delete");
        }

        Node<T> node = head;
        for (int index = 0; index < (size() - 2); index++) {
            node = node.next;
        }
        tail = node;
        node.next = head;
        numberOfElement--;
    }

    /**
     * Delete first element in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    public void deleteFirst() throws EmptyLinkedListException {
        if (head == null) {
            throw new EmptyLinkedListException("No element in Linked List to delete");
        }
        if (size() == 1) {
            tail = null;
            head = null;
        } else {
            tail.next = head.next;
            head = head.next;
        }
        numberOfElement--;
    }

    /**
     * Delete element at specified position in LinkedList
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     */
    public void delete(int position) throws EmptyLinkedListException {
        if (size() == 0) {
            throw new EmptyLinkedListException("Linked List is empty no element can be deleted.");
        } else if (position < 0 || position >= size()) {
            throw new IndexOutOfBoundsException("Index from range 0 to " + (size() - 1) + " can be deleted");
        } else if (position == 0) {
            deleteFirst();
        } else if (position == (size() - 1)) {
            deleteLast();
        } else {
            Node<T> node = head;
            for (int index = 0; index < size(); index++) {
                if (index == position - 1) {
                    node.next = node.next.next;
                    numberOfElement--;
                    return;
                }
                node = node.next;
            }
        }
    }

    /**
     * Destroy linked list by setting head and tail as 0.
     * <p>
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    public void destroy() {
        head = null;
        if (tail != null)
            tail.next = null;
        tail = null;
        numberOfElement = 0;
    }

    /**
     * Get number of elements in linkedlist.
     * <p>
     * Time Complexity - O(1)
     * Space Complexity - O(1)
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
        if (size() == 0 || this.head == null) {
            throw new EmptyLinkedListException("No element found in list");
        }
        return this.head.element;
    }

    /**
     * Get Last element of Linked List
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @return T - Last element in linked list.
     */
    public T getLast() throws EmptyLinkedListException {
        if (size() == 0 || this.tail == null) {
            throw new EmptyLinkedListException("No element found in list");
        }
        return this.tail.element;
    }

    /**
     * Get element at specified position in Linked List
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     *
     * @return T - Last element in linked list.
     */
    public T get(int index) throws EmptyLinkedListException {
        if (size() == 0) {
            throw new EmptyLinkedListException("No element found in list");
        }
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index should be in between 0 and " + (size() - 1));
        }
        int position = 0;
        Node<T> node = head;
        while (position < index) {
            node = node.next;
            position++;
        }
        return node.element;
    }

    /**
     * @return - To traverse through element in collection.
     * <p>
     * NOTE: ConcurrentModification of list will give unpredicatable output. So avoid list modification while traversal.
     */
    public Iterator<T> iterator() {
        return new CircularLinkedListIterator(head);
    }

    class CircularLinkedListIterator implements Iterator<T> {
        Node<T> node;
        Node<T> head;

        public CircularLinkedListIterator(Node<T> head) {
            this.head = head;
        }

        public boolean hasNext() {
            return size() != 0;
        }

        public T next() {
            if (node == null) {
                node = head;
            } else {
                node = node.next;
            }
            return node.element;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
