package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class HybridSort  extends SortingAlgorithm {
    /**
     * Generates a hybrid sort class
     */
    public HybridSort() {
    }

    private static final int BEGIN_INSERTION = 10;

    /**
     * A generic array sort algorithm that performs a hybrid sort.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    @Override
    public <E extends Comparable> void sort(E[] array){
        if(array == null)
            throw new IllegalArgumentException();
        else
            hybridSort(array, 0, array.length - 1);
    }

    /**
     * Performs a hybrid sort algorithm on an array
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     * @param left Left most position in the array
     * @param right Right most position in the array
     */
    private <E extends Comparable> void hybridSort(E[] array, int left, int right) {
        if (right - left < BEGIN_INSERTION) {
            for (int i = left; i <= right; ++i) {
                insertionSort(array, i, array[i]);
            }
        }
        else if (left < right){
            int pivot = partition(array, left, right);
            if(pivot - 1 - left <= BEGIN_INSERTION){
                for (int i = left; i <= pivot - 1; ++i){
                    insertionSort(array, i, array[i]);
                }
            } else {
                hybridSort(array, left, pivot - 1);
            }
            if (right - pivot + 1 <= BEGIN_INSERTION){
                for (int i = pivot + 1; i <= right; ++i){
                    insertionSort(array, i, array[i]);
                }
            } else {
                hybridSort(array, pivot + 1, right);
            }
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
     * @return the pivot index
     */
    private <E extends Comparable> int selectPivot(E[] array, int left, int right){
        return left;
    }
}
