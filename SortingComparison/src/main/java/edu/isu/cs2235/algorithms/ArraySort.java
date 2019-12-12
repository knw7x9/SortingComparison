package edu.isu.cs2235.algorithms;

/**
 * A strategy pattern implementation of generic array sorting algorithms
 * @author Isaac Griffith
 */
public interface ArraySort {

    /**
     * An interface for a generic array sort algorithm.
     *
     * @param <E> Type of array contents, must extend Comparable Interface.
     * @param array Array to be sorted.
     */
    <E extends Comparable> void sort(E[] array);
}
