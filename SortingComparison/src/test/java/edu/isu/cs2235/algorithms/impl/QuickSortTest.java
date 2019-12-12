package edu.isu.cs2235.algorithms.impl;

import edu.isu.cs2235.algorithms.ArraySort;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isaac Griffith
 */
public class QuickSortTest {

    private ArraySort fixture;

    public QuickSortTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new QuickSort();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSort() {
        Integer[] array = new Integer[20];
        for (int i = 19; i >= 0; i--)
            array[i] = i;
        fixture.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            assertTrue("Array was not sorted i ascending order, as expected", array[i] <= array[i + 1]);
        }
    }

    @Test
    public void testSort_2() {
        Integer[] array = new Integer[20];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);
        fixture.sort(array);

        for (int i = 0; i < array.length - 1; i++)
            assertTrue("Array was not sorted in ascending order, as expected", array[i] <= array[i + 1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSort_3() {
        fixture.sort(null);
        fail("Did not throw an IllegalArgumentException for null array");
    }

}
