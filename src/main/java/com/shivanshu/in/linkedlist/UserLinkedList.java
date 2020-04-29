package com.shivanshu.in.linkedlist;

public interface UserLinkedList<T> {
    /**
     * Insert element at start of LinkedList
     *
     * @param element - to be inserted in LinkedList
     */
    void insertFirst(T element);

    /**
     * Insert element at last of LinkedList
     *
     * @param element- to be inserted in LinkedList
     */
    void insertLast(T element);

    /**
     * Insert element at specified position
     *
     * @param element  - to be inserted in Linked
     * @param position - at which element need to be inserted
     */
    void insert(T element, int position);

    /**
     * Insert element
     *
     * @param element
     */
    void insert(T element);


    /**
     * Check if LinkedList contains an element.
     *
     * @param element - element to be search in LinkedList
     * @return - true if element found
     */
    boolean contain(T element);

    /**
     * Delete an element from linkedList
     *
     * @param element - to be deleted from LinkedList
     */
    void delete(T element);

    /**
     * Delete last element in linked list.
     */
    void deleteLast();

    /**
     * Delete first element in linked list.
     */
    void deleteFirst();

    /**
     * Delete element/node at specified position
     *
     * @param position - at which we have to delete element.
     */
    void delete(int position);

    /**
     * Destroy LinkedList
     */
    void destroy();

    /**
     * Get linked list size
     *
     * @return - number of nodes/element in Linked list
     */
    int size();

    /**
     * Get first element in linkedlist
     *
     * @return - First element in linked list
     */
    T getFirst();

    /**
     * Get last element in linkedlist
     *
     * @return - Last element in Linked list
     */
    T getLast();

    /**
     * Get element at specified position.
     *
     * @param position - Position in linked list
     * @return - Element
     */
    T get(int position);
}