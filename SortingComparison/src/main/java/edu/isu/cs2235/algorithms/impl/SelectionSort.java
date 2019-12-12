package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class SelectionSort extends SortingAlgorithm {
    /**
     * Generates a selection sort class
     */
    public SelectionSort() {
    }

    /**
     * A generic array sort algorithm that performs a selection sort.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array){
        if(array == null)
            throw new IllegalArgumentException();
        else
            selectionSort(array);
    }

    /**
     *Performs an selection sort algorithm on an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    private <E extends Comparable> void selectionSort(E[] array){
        for (int firstUnsorted = 0; firstUnsorted < array.length - 1; ++firstUnsorted){
            int min = firstUnsorted;
            for (int i = min; i < array.length; ++i){
                if (array[i].compareTo(array[min]) < 0){
                    min = i;

                }

            }
            swap(array, firstUnsorted, min);
        }
    }
}
