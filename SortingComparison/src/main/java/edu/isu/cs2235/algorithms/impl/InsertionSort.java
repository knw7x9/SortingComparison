package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class InsertionSort extends SortingAlgorithm {
    /**
     * Generates an insertion sort class
     */
    public InsertionSort() {
    }

    /**
     * A generic array sort algorithm that performs a insertion sort.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array){
        if(array == null)
            throw new IllegalArgumentException();
        else {
            for (int i = 1; i < array.length; ++i)
                insertionSort(array, i, array[i]);
        }
    }

    /**
     * Performs an insertion sort algorithm on an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param pos Position in the array
     * @param value Value at the position in the array
     */
    private <E extends Comparable> void insertionSort(E[] array, int pos, E value){
        int i = pos - 1;
        while (i >=0 && array[i].compareTo(value) > 0) {
            array[i + 1] = array[i];
            i -= 1;
        }
        array[i + 1] = value;
    }
}
