package org.amw061.interview;

import org.junit.jupiter.api.Test;

import static org.amw061.interview.SearchType.FIRST;
import static org.amw061.interview.SearchType.LAST;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();
    private static final int[] array1 = {1, 3, 5, 5, 6, 8, 10, 15, 21, 23, 99};
    private static final int[] array2 = {1, 1, 1, 1, 1, 1, 1};

    @Test
    void indexOf() {
        assertEquals(0, binarySearch.indexOf(1, array1));
        assertEquals(1, binarySearch.indexOf(3, array1));
        assertEquals(2, binarySearch.indexOf(5, array1));
        assertEquals(4, binarySearch.indexOf(6, array1));
        assertEquals(5, binarySearch.indexOf(8, array1));
        assertEquals(6, binarySearch.indexOf(10, array1));
        assertEquals(7, binarySearch.indexOf(15, array1));
        assertEquals(8, binarySearch.indexOf(21, array1));
        assertEquals(9, binarySearch.indexOf(23, array1));
        assertEquals(10, binarySearch.indexOf(99, array1));

        assertEquals(2, binarySearch.indexOf(5, array1, FIRST));
        assertEquals(3, binarySearch.indexOf(5, array1, LAST));

        assertEquals(-1, binarySearch.indexOf(50, array1));
        assertEquals(-1, binarySearch.indexOf(200, array1));

        assertEquals(3, binarySearch.indexOf(1, array2));
        assertEquals(0, binarySearch.indexOf(1, array2, FIRST));
        assertEquals(6, binarySearch.indexOf(1, array2, LAST));

        assertEquals(-1, binarySearch.indexOf(1, new int[]{}));
    }

    @Test
    void findAllOccurrences() {
        assertEquals(1, binarySearch.findAllOccurrences(23, array1));
        assertEquals(2, binarySearch.findAllOccurrences(5, array1));
        assertEquals(7, binarySearch.findAllOccurrences(1, array2));
        assertEquals(0, binarySearch.findAllOccurrences(10, array2));
    }
}