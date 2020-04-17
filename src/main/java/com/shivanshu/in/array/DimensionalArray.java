package com.shivanshu.in.array;

public interface DimensionalArray {
    /**
     * Traverse all element in single dimensional array.
     *
     * @param seperator - In return string elements will be seperated as per provided seperator
     * @return - String with all elements seperated by input seperator
     */
    String traverse(String seperator);
    /**
     * Insert a element at a given location.
     * @param location - array location where element need to be inserted.
     * @param valueToBeInserted - element to be inserted in array
     * @return - true if insertion successful.
     */
    boolean insert(int location, int valueToBeInserted);
    /**
     * Return element at specified location in array.
     * @param cellNumber - position in array.
     * @return - element at specified position.
     */
    int access(int cellNumber);
    /**
     * Search an element in an array.
     * @param valueToSearch - Element to be search in array
     * @return cell location in array or -1 if value not found
     */
    int search(int valueToSearch);
    /**
     * Delete an element from array and shrink array to fill empty location by next element.
     * @param value - element to be deleted from array.
     * @throws ValueNotFoundException - If value to be deleted not found in array.
     */
    void delete(int value) throws ValueNotFoundException;
    /**
     * @return size of an array.
     */
    int size();
}
