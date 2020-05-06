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
    void delete(T element) throws EmptyLinkedListException;

    /**
     * Delete last element in linked list.
     */
    void deleteLast() throws EmptyLinkedListException;

    /**
     * Delete first element in linked list.
     */
    void deleteFirst() throws EmptyLinkedListException;

    /**
     * Delete element/node at specified position
     *
     * @param position - at which we have to delete element.
     */
    void delete(int position) throws EmptyLinkedListException;

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
     * @throws  - {@link EmptyLinkedListException}
     */
    T getFirst() throws EmptyLinkedListException;

    /**
     * Get last element in linkedlist
     *
     * @return - Last element in Linked list
     * @throws EmptyLinkedListException
     */
    T getLast() throws  EmptyLinkedListException;

    /**
     * Get element at specified position.
     *
     * @param index - in linked list
     * @return - element at indexed position
     * @throws - {@link EmptyLinkedListException}
     */
    T get(int index) throws  EmptyLinkedListException;
}