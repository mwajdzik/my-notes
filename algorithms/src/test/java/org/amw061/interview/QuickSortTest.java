package org.amw061.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    void sort() {
        int[] inputArray = {43, 78, 11, 33, 99, 77, 56, 81, 9, 1, 23};
        int[] expectedArray = {1, 9, 11, 23, 33, 43, 56, 77, 78, 81, 99};
        quickSort.sort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void pivot() {
        int[] array = {43, 78, 11, 33, 99, 77, 56, 81, 9, 1, 23};
        assertEquals(3, quickSort.partition(array, 0, array.length - 1));
    }
}