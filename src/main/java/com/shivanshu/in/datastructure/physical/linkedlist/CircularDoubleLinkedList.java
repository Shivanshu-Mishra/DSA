package com.shivanshu.in.datastructure.physical.linkedlist;

import com.shivanshu.in.datastructure.physical.linkedlist.DoubleLinkedList.Node;

import java.util.Iterator;

/**
 * In Double Linked List each node contain reference to previous and next node
 * beside that each node have data item. Last node will refer to null as next reference.
 *
 * @param <T>
 */
public class CircularDoubleLinkedList<T> implements UserLinkedList<T>, Iterable<T> {
    private int numberOfElement = 0;
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
        if (head == null && tail == null) {
            head = new Node<T>(element, null, null);
            tail = head;
        } else {
            Node<T> newNode = new Node<T>(element, tail, head);
            head.previous = newNode;
            tail.next = newNode;
            head = newNode;
        }
        numberOfElement++;
    }

    /**
     * Insert element at last position in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param element - element to be inserted
     */
    public void insertLast(T element) {
        if (head == null && tail == null) {
            tail = new Node<T>(element, null, null);
            head = tail;
        } else {
            Node<T> newNode = new Node<T>(element, tail, head);
            tail.next = newNode;
            head.previous = newNode;
            tail = newNode;
        }
        numberOfElement++;
    }

    /**
     * Insert element at specified position in LinkedList
     * Time Complexity - O(N/2)
     * Space Complexity - O(1)
     *
     * @param element - element to be inserted
     */
    public void insert(T element, int position) {
        if (position < 0 || position > size()) {
            throw new IndexOutOfBoundsException("New element can be inserted only" +
                    " from 0 and " + size());
        } else if (position == 0) {
            insertFirst(element);
        } else if (position == size()) {
            insertLast(element);
        } else if (position <= size() / 2) {
            Node<T> node = head.next;
            for (int index = 1; index <= (size() / 2); index++) {
                if (index == position) {
                    insertElement(node, element);
                }
                node = node.next;
            }
        } else {
            Node<T> node = tail.previous;
            for (int index = size() - 1; index > (size() / 2); index--) {
                if (index == position) {
                    insertElement(node, element);
                }
                node = node.previous;
            }
        }
    }

    private void insertElement(Node<T> node, T element) {
        Node<T> newNode = new Node<T>(element, node.previous, node);
        node.previous.next = newNode;
        node.previous = newNode;
        numberOfElement++;
    }

    /**
     * Insert element in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @param element - element to be inserted
     */
    public void insert(T element) {
        insertLast(element);
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

    public void delete(T element) throws EmptyLinkedListException {
        validateIfLinkedListIsEmpty();
        Node<T> node = head;
        for (int index = 0; index < size(); index++) {
            if (node.element.equals(element)) {
                if (index == 0) {
                    deleteFirst();
                } else if (index == size() - 1) {
                    deleteLast();
                } else {
                    deleteElement(node);
                }
            }
            node = node.next;
        }
    }

    /**
     * Delete last element in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    public void deleteLast() throws EmptyLinkedListException {
        validateIfLinkedListIsEmpty();
        if (size() == 1) {
            head.previous = null;
            head = null;
            tail.next = null;
            tail = null;
        } else {
            tail.previous.next = head;
            tail = tail.previous;
            head.previous = tail;
        }
        numberOfElement--;
    }

    /**
     * Delete first element in LinkedList
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     */
    public void deleteFirst() throws EmptyLinkedListException {
        validateIfLinkedListIsEmpty();
        if (size() == 1) {
            head.previous = null;
            head = null;
            tail.next = null;
            tail = null;
        } else {
            head.next.previous = null;
            tail.previous = head.next;
            head = head.next;
        }
        numberOfElement--;
    }

    /**
     * Delete element at specified position in LinkedList
     * Time Complexity - O(N/2)
     * Space Complexity - O(1)
     */
    public void delete(int position) throws EmptyLinkedListException {
        validateIfLinkedListIsEmpty();
        if (position < 0 || position == size()) {
            throw new IndexOutOfBoundsException("Element can be deleted from size 0 to " + (size() - 1));
        } else if (position == 0) {
            deleteFirst();
        } else if (position == size() - 1) {
            deleteLast();
        } else if (position <= size() / 2) {
            Node<T> node = head.next;
            for (int index = 1; index <= (size() / 2); index++) {
                if (index == position) {
                    deleteElement(node);
                    return;
                }
                node = node.next;
            }
        } else {
            Node<T> node = tail.previous;
            for (int index = size() - 1; index > (size() / 2); index--) {
                if (index == position) {
                    deleteElement(node);
                    return;
                }
                node = node.previous;
            }
        }
    }

    private void deleteElement(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        numberOfElement--;
    }

    private void validateIfLinkedListIsEmpty() throws EmptyLinkedListException {
        if (size() == 0) {
            throw new EmptyLinkedListException("Operation not allowed as linked list is empty");
        }
    }

    /**
     * Destroy linked list.
     * <p>
     * Time Complexity - O(N)
     * Space Complexity - O(1)
     */
    public void destroy() {
        Node<T> node = head;
        for (int index = 0; index < size(); index++) {
            node.previous = null;
            node = node.next;
        }
        head = null;
        tail.next = null;
        tail = null;
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
        if (size() == 0) {
            throw new EmptyLinkedListException("No element can be fetched from empty list.");
        }
        return head.element;
    }

    /**
     * Get last element of Linked List
     * Time Complexity - O(1)
     * Space Complexity - O(1)
     *
     * @return T - last element in linked list.
     */
    public T getLast() throws EmptyLinkedListException {
        if (size() == 0) {
            throw new EmptyLinkedListException("No element can be fetched from empty list.");
        }
        return tail.element;
    }

    /**
     * Insert element at specified position in LinkedList
     * Time Complexity - O(N/2)
     * Space Complexity - O(1)
     *
     * @param index - element to be inserted
     */
    public T get(int index) throws EmptyLinkedListException {
        if (size() == 0) {
            throw new EmptyLinkedListException("No element can be fetched from empty list");
        }

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index should be in between 0 and " + size());
        }
        Node<T> node = null;
        if (index > size() / 2) {
            node = tail;
            for (int pos = size() - 1; pos > index; pos--) {
                node = node.previous;
            }
        } else {
            node = head;
            for (int pos = 0; pos < index; pos++) {
                node = node.next;
            }
        }
        return node.element;
    }

    /**
     * @return - To traverse through element in collection in forward and backward directions.
     * <p>
     * NOTE: ConcurrentModification of list will give unpredicatable output. So avoid list modification while traversal.
     */
    public DoubleLinkedListIterator<T> iterator() {
        return new DoubleLinkedListIterator<T>(head);
    }


    class DoubleLinkedListIterator<T> implements Iterator<T> {
        Node<T> node;
        Node<T> previous;

        public DoubleLinkedListIterator(Node<T> head) {
            this.node = head;
        }

        public boolean hasNext() {
            return node != null;
        }

        public boolean hasPrevious() {
            return previous != null;
        }

        public T next() {
            T element = node.element;
            previous = node.previous;
            node = node.next;
            return element;
        }

        public T previous() {
            T element = previous.element;
            node = previous.next;
            previous = previous.previous;
            return element;
        }

        public void remove() {
            throw new UnsupportedOperationException("During iteration remove is not allowed");
        }
    }
}
