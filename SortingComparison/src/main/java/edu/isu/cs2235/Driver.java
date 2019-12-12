package edu.isu.cs2235;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import edu.isu.cs2235.algorithms.ArraySort;
import edu.isu.cs2235.algorithms.impl.SortingAlgorithm;
import edu.isu.cs2235.algorithms.impl.MergeSort;
import edu.isu.cs2235.algorithms.impl.HybridSort;
import edu.isu.cs2235.algorithms.impl.InsertionSort;
import edu.isu.cs2235.algorithms.impl.QuickSort;
import edu.isu.cs2235.algorithms.impl.SelectionSort;
import edu.isu.cs2235.algorithms.impl.TimSort;

/**
 * @author Katherine Wilsdon
 */
public class Driver {

    enum SortingAlgorithm{
        N(0), MergeSort(1), QuickSort(2), InsertionSort(3), SelectionSort(4), TimSort(5), HybridSort(6);
        private int value;
        private SortingAlgorithm(int value) {
            this.value = value;
        }
        private int getValue(){
            return value;
        }
    }

    public static void main(String[] args) {
        try {
            // Create csv file
            File file = new File("report.csv");
            file.createNewFile();
            FileWriter csvWriter = new FileWriter(file);
            csvWriter.write("N, MergeSort, QuickSort, InsertionSort, SelectionSort, TimSort, HybridSort\r\n");
            System.out.print("N, MergeSort, QuickSort, InsertionSort, SelectionSort, TimSort, HybridSort\r\n");

            Integer[] array;
            long[][] averageTime = new long[10][7];
            int startingPoint = 10000;
            int numOfIterations = 50;
            int increment = 10000;
            long start = 0;
            long stop = 0;
            long difference = 0;

            Random rand = new Random();
            for (int i = 0; i < numOfIterations; ++i){
                for (int j = 0; j < 10; ++j){
                    // Create and populate the array
                    array = new Integer[startingPoint + (j * increment)];
                    for (int k = 0; k < array.length; ++k) {
                        array[k] = rand.nextInt(100000);
                    }
                    // Run each sorting algorithm
                    for (SortingAlgorithm algrthm : SortingAlgorithm.values()){
                        switch (algrthm){
                            case N:
                                averageTime[j][0] = startingPoint + (j * increment);
                                break;
                            case MergeSort:
                                MergeSort mergeSort = new MergeSort();
                                Integer[] copy1 = Arrays.copyOf(array, array.length);
                                start = System.nanoTime();
                                mergeSort.sort(copy1);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][SortingAlgorithm.MergeSort.getValue()] += difference;
                                break;
                            case QuickSort:
                                QuickSort quickSort = new QuickSort();
                                Integer[] copy2 = Arrays.copyOf(array, array.length);
                                start = System.nanoTime();
                                quickSort.sort(copy2);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][SortingAlgorithm.QuickSort.getValue()] += difference;
                                break;
                            case InsertionSort:
                                InsertionSort insertionSort = new InsertionSort();
                                Integer[] copy3 = Arrays.copyOf(array, array.length);
                                start = System.nanoTime();
                                insertionSort.sort(copy3);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][SortingAlgorithm.InsertionSort.getValue()] += difference;
                                break;
                            case SelectionSort:
                                SelectionSort selectionSort = new SelectionSort();
                                Integer[] copy4 = Arrays.copyOf(array, array.length);
                                start = System.nanoTime();
                                selectionSort.sort(copy4);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][SortingAlgorithm.SelectionSort.getValue()] += difference;
                                break;
                            case TimSort:
                                TimSort timSort = new TimSort();
                                Integer[] copy5 = Arrays.copyOf(array, array.length);
                                start = System.nanoTime();
                                timSort.sort(copy5);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][SortingAlgorithm.TimSort.getValue()] += difference;
                                break;
                            case HybridSort:
                                HybridSort hybridSort = new HybridSort();
                                Integer[] copy6 = Arrays.copyOf(array, array.length);
                                start = System.nanoTime();
                                hybridSort.sort(copy6);
                                stop = System.nanoTime();
                                difference = stop - start;
                                averageTime[j][SortingAlgorithm.HybridSort.getValue()] += difference;
                                break;
                        }
                    }
                }
            }
            for (int i = 0; i < averageTime.length; ++i){
                for (int j = 0; j < averageTime[0].length; ++j) {
                    // Get average
                    if (j != 0)
                        averageTime[i][j] = averageTime[i][j] / numOfIterations;
                    // Write to csv and print to screen
                    csvWriter.write(Long.toString(averageTime[i][j]));
                    System.out.println(averageTime[i][j]);
                    // Separate by a comma
                    if (j != SortingAlgorithm.HybridSort.getValue()) {
                        csvWriter.write(",");
                        System.out.print(",");
                    } // If last item, insert a new line
                    else if (j == SortingAlgorithm.HybridSort.getValue()) {
                        csvWriter.write("\r\n");
                        System.out.print("\r\n");
                    }
                }
            }
            System.out.println(file.getAbsolutePath());
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e){
            System.err.println("An IOException was caught : " + e.getMessage());
        }
    }
}
