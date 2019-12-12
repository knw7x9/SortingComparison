package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public abstract class SortingAlgorithm implements edu.isu.cs2235.algorithms.ArraySort {
    /**
     * Generates a sorting algorithm class
     */
    public SortingAlgorithm() {
    }

    /**
     * Swaps the position of two elements in an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param first First element in the array to be swapped
     * @param second Second element in the array to be swapped
     */
    protected <E extends Comparable> void swap(E[] array, int first, int second){
        E temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * A generic array sort algorithm.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    @Override
    public abstract <E extends Comparable> void sort(E[] array);
}
