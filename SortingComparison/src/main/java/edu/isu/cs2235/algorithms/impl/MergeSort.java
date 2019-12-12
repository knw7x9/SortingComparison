package edu.isu.cs2235.algorithms.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Katherine Wilsdon
 * @param <E> Type of array contents, must extend Comparable Interface.
 */
public class MergeSort <E> extends SortingAlgorithm {
    /**
     * Generates a merge sort class
     */
    public MergeSort() {
    }

    /**
     * A generic array sort algorithm that performs a merge sort.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array){
        if(array == null)
            throw new IllegalArgumentException();
        else {
            E[] copy = copy(array, 0, array.length );
            mergeSort(copy, array, 0, array.length - 1);
        }

    }

    /**
     * Performs a merge sort algorithm on an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array A copy of the array to be sorted
     * @param result The resulting array from sorting
     * @param start The starting position of the array
     * @param end The ending position of the array
     */
    private <E extends Comparable> void mergeSort(E[] array, E[] result, int start, int end){
        if (end == start)
            return;
        if (end - start < 2){
            if (result[start].compareTo(result[end]) > 0)
                swap(result, start, end);
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(result, array, start, mid);
        mergeSort(result, array, mid + 1, end);
        int i = start;
        int j = mid + 1;
        for (int index = start; index <= end; ++index){
            if (j > end || (i <= mid && array[i].compareTo(array[j]) < 0)) {
                result[index] = array[i];
                i += 1;
            } else {
                result[index] = array[j];
                j += 1;
            }
        }
    }

    /**
     * Create a copy of an array.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param start Starting position in array.
     * @param end Ending position in array.
     * @return A copy of the provided array
     */
    private <E extends Comparable> E[] copy(E[] array, int start, int end){
        E[] copy = java.util.Arrays.copyOf(array,array.length);
        return copy;
    }
}
