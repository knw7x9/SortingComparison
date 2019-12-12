package edu.isu.cs2235.algorithms.impl;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Katherine Wilsdon
 */
public class TimSort extends SortingAlgorithm {
    /**
     * Generates a Tim sort class
     */
    public TimSort() {
    }

    private static final int RUN = 10;

    /**
     * A generic array sort algorithm for tim sort.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array){
        if(array == null)
            throw new IllegalArgumentException();
        else {
            timSort(array);
        }
    }


    /**
     * Performs an Tim sort algorithm on an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * A Tim sort video was used for understanding: https://www.youtube.com/watch?v=9kFHVe5MT6o
     */
    private <E extends Comparable> void timSort(E[] array){
        for (int i = 0; i < array.length; i += RUN) {
            // Perform insertion sort on all sections except the last
            if(i + RUN - 1 < array.length - 1) {
                for (int j = i; j < i + RUN; ++j)
                    insertionSort(array, j, array[j], i);
            }
            // Perform insertion sort on the last section of the array
            else {
                for (int j = i; j < array.length; ++j)
                    insertionSort(array, j, array[j], i);
            }
        }
        // incrRUN is the section of the array used for merge sort
        int incrRUN = RUN;
        E[] copy;
        while (incrRUN < array.length){
            for (int i = 0; i < array.length; i += 128 * incrRUN){
                copy = Arrays.copyOf(array, array.length);
                // Perform merge sort on all sections except the last
                if(i + (128 * incrRUN) - 1 < array.length - 1)
                    mergeSort(copy, array, i, i + (128 * incrRUN) - 1);
                // Perform merge sort on the last section of the array
                else
                    mergeSort(copy, array, i, array.length - 1);
            }
            // Increment the section of the array used for merge sort
            incrRUN *= 128;
        }
    }

    /**
     * Performs an insertion sort algorithm on an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param pos  Position in the array
     * @param value Value at the position in the array
     * @param start The starting position to begin insertion sort
     */
    private <E extends Comparable> void insertionSort(E[] array, int pos, E value, int start){
        int i = pos - 1;
        while (i >= start && array[i].compareTo(value) > 0) {
            array[i + 1] = array[i];
            i -= 1;
        }
        array[i + 1] = value;
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
    private <E extends Comparable> void mergeSort(E[] array, E[] result, int start, int end) {
        if (end == start)
            return;
        if (end - start < 2) {
            if (result[start].compareTo(result[end]) > 0)
                swap(result, start, end);
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(result, array, start, mid);
        mergeSort(result, array, mid + 1, end);
        int i = start;
        int j = mid + 1;
        for (int index = start; index <= end; ++index) {
            if (j > end || (i <= mid && array[i].compareTo(array[j]) < 0)) {
                result[index] = array[i];
                i += 1;
            } else {
                result[index] = array[j];
                j += 1;
            }
        }
    }
}
