package com.shivanshu.in.array;

public class TwoDimensionalArray {
    private int column;
    private int row;
    private int[][] tdarray;
    private int totalElement = 0;


    /**
     * Constructor
     * <p>
     * Time Complexity - O(nm) where n is row and m is column.
     * Space Complexity - O(nm) where n is row and m is column.
     *
     * @param row
     * @param column
     */
    public TwoDimensionalArray(int row, int column) {
        tdarray = new int[row][column];
        for (int horizon = 0; horizon < row; horizon++) {
            for (int vertical = 0; vertical < column; vertical++) {
                tdarray[horizon][vertical] = Integer.MIN_VALUE;
            }
        }
        this.row = row;
        this.column = column;
    }

    /**
     * Traverse through all items in 2D array and create a string of element seperated by supplied seperator.
     * <p>
     * Time Complexity - O(nm) where n is row and m is column.
     * Space Complexity - O(1) .
     *
     * @param seperator
     * @return - elements of array appended through seperator
     */
    public String traverse(String seperator) {
        StringBuffer buffer = new StringBuffer();
        int elementNumber = 1;
        for (int horizon = 0; horizon < this.row; horizon++) {
            for (int vertical = 0; vertical < this.column; vertical++) {
                int element = access(horizon, vertical);
                if (element == Integer.MIN_VALUE) {
                    continue;
                }
                if (elementNumber < totalElement) {
                    buffer.append(element).append(seperator);
                } else if (elementNumber == totalElement) {
                    buffer.append(element);
                }
                elementNumber++;
            }
        }
        return buffer.toString();
    }

    /**
     * Insert an element at specified row and column in 2D array.
     * <p>
     * Time Complexity - O(1) constant time.
     * Space Complexity - O(1) constant space.
     *
     * @param row
     * @param column
     * @param valueToBeInserted
     * @return - true if insertion successful, false if there is some other value than Integer.MIN_VALUE.
     */
    public boolean insert(int row, int column, int valueToBeInserted) {
        if (access(row, column) == Integer.MIN_VALUE) {
            tdarray[row][column] = valueToBeInserted;
            totalElement++;
            return true;
        }
        return false;
    }

    /**
     * Access element at specified row and column.
     * <p>
     * Time Complexity - O(1) constant time.
     * Space Complexity - O(1) constant space.
     *
     * @param row
     * @param column
     * @return - element at location
     */
    public int access(int row, int column) {
        return tdarray[row][column];
    }

    /**
     * Search an element in 2D array and return location of its first occurrence.
     * Time Complexity - O(NM) where N is row and M is column.
     * Space Complexity - O(1) constant space.
     *
     * @param valueToSearch
     * @return - Location of first occurrence of number
     */
    public Location search(int valueToSearch) {
        for (int horizon = 0; horizon < this.row; horizon++) {
            for (int vertical = 0; vertical < this.column; vertical++) {
                if (access(horizon, vertical) == valueToSearch)
                    return new Location(horizon, vertical);
            }
        }
        return new Location(-1, -1);
    }

    /**
     * Delete first occurrence of number.
     * Time Complexity - O(NM) where N is row and M is column.
     * Space Complexity - O(1) constant space.
     *
     * @param value - Value to be deleted
     * @throws ValueNotFoundException
     */
    public void delete(int value) throws ValueNotFoundException {
        int valueRowPos = -1;
        for (int horizon = 0; horizon < row; horizon++) {
            for (int vertical = 0; vertical < column; vertical++) {
                if (tdarray[horizon][vertical] == value) {
                    tdarray[horizon][vertical] = Integer.MIN_VALUE;
                    totalElement--;
                    valueRowPos = horizon;
                    break;
                }
            }
        }
        if (valueRowPos == -1) {
            throw new ValueNotFoundException(value + " does not exist in 2D array");
        }
    }

    /**
     * Total number of element in 2D array
     * Time Complexity - O(1) where N is row and M is column.
     * Space Complexity - O(1) constant space.
     *
     * @return - number of element
     */
    public int size() {
        return totalElement;
    }

    /**
     * Static class to represent position of an element in 2D array
     */
    static class Location {
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }
    }
}
