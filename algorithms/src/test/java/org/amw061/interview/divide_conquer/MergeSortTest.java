package org.amw061.interview.divide_conquer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private static final Random r = new Random(23);

    @Test
    void solveSingleElement() {
        assertArrayEquals(new int[]{23}, new MergeSort().sort(new int[]{23}));
    }

    @Test
    void solveNineElements() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5, 9, 10, 12},
                new MergeSort().sort(new int[]{3, 1, 9, 4, 4, 10, 2, 12, 5}));
    }

    @Test
    void solveRandomElements() {
        int[] array = new int[100_000_000];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(0, array.length);
        }

        new MergeSort().sort(array);
    }
}