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
public class HybridSortTest {

    private ArraySort fixture;

    public HybridSortTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new HybridSort();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sort method, of class QuickSort.
     */
    @Test
    public void testSort() {
        Integer[] array = {5, 4, 3, 2, 1};
        fixture.sort(array);

        for (int i = 0; i < array.length; i++)
            assertEquals("Array was not sorted in ascending order, as expected", new Integer(i + 1), array[i]);
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
