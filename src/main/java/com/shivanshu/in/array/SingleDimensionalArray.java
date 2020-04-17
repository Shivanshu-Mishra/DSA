package com.shivanshu.in.array;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;

public class SingleDimensionalArray implements DimensionalArray {

    private int[] sdaArray;
    private int sdaArraySize = 0;

    /**
     * Constructor
     * Time complexity - O(N)
     * Space complexity - O(N)
     *
     * @param size - Single dimensional array size
     */
    public SingleDimensionalArray(int size) {
        sdaArray = new int[size];
        for (int i = 0; i < size; i++) {
            sdaArray[i] = Integer.MIN_VALUE;
        }
    }

    /**
     * Time complexity - O(N)
     * Space complexity - O(1)
     */
    public String traverse(String seperator) {
        StringBuffer buffer = new StringBuffer();
        for (int loc = 0; loc < sdaArraySize; loc++) {
            buffer.append(sdaArray[loc]);
            if (loc != sdaArraySize - 1) {
                buffer.append(seperator);
            }
        }
        return buffer.toString();
    }

    /**
     * Time Complexity - O(1)
     * Space Complexity -  O(1)
     */
    public boolean insert(int location, int valueToBeInserted) {
        if (sdaArray[location] == Integer.MIN_VALUE) {
            sdaArray[location] = valueToBeInserted;
            sdaArraySize++;
            return true;
        }
        return false;
    }

    /**
     * Time Complexity - O(1)
     * Space Complexity -  O(1)
     */
    public int access(int cellNumber) {
        return sdaArray[cellNumber];
    }

    /**
     * Time Complexity - O(N) for unsorted data, for sorted data and with binary search it can be O(logN)
     * Space Complexity -  O(1)
     */
    public int search(int valueToSearch) {
        for (int loc = 0; loc < sdaArraySize; loc++) {
            if (sdaArray[loc] == valueToSearch) {
                return loc;
            }
        }
        return -1;
    }

    /**
     * Time complexity - O(N)
     * Space complexity - O(1)
     */
    public void delete(int value) throws ValueNotFoundException {
        int elementPos = -1;
        for (int loc = 0; loc < sdaArraySize; loc++) {
            if (sdaArray[loc] == value) {
                elementPos = loc;
                break;
            }
        }
        if (elementPos == -1) {
            throw new ValueNotFoundException(value + " not present in array");
        }

        for (int pos = elementPos; pos < sdaArraySize - 1; pos++) {
            sdaArray[pos] = sdaArray[pos + 1];
        }
        sdaArray[sdaArraySize] = Integer.MIN_VALUE;
        sdaArraySize--;
    }

    /**
     * Time complexity - O(1)
     * Space complexity - O(1)
     */
    public int size() {
        return sdaArraySize;
    }
}