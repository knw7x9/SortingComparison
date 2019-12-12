package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class QuickSort extends SortingAlgorithm {
    /**
     * Generates a quick sort class
     */
    public QuickSort() {
    }

    /**
     * A generic array sort algorithm that performs a quick sort.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array){
        if(array == null)
            throw new IllegalArgumentException();
        else
            quickSort(array, 0, array.length - 1);
    }

    /**
     * Performs a quick sort algorithm on an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param left The left most position in the array
     * @param right The right most position in the array
     */
    private <E extends Comparable> void quickSort(E[] array, int left, int right){
        if (left < right){
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    /**
     * Determines the final position of the pivot in the partition
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param left The left most position of the partition in the array
     * @param right The right most position of the partition in the array
     * @return The final index of the pivot
     */
    private <E extends Comparable> int partition(E[] array, int left, int right){
        int pivotIndex = selectPivot(array, left, right);
        E pivot = array[pivotIndex];
        int store = pivotIndex + 1;
        for (int i = pivotIndex + 1; i <= right; ++i){
            if (array[i].compareTo(pivot) <= 0) {
                swap(array, i, store);
                store += 1;
            }
        }
        swap(array, store - 1, pivotIndex);
        return store - 1;
    }

    /**
     * Selects the pivot index
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param left The left most position of the partition in the array
     * @param right The right most position of the partition in the array
     * @return The pivot index
     */
    private <E extends Comparable> int selectPivot(E[] array, int left, int right){
        return left;
    }
}
