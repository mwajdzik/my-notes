package org.amw061.interview.sorting;

public class InsertionSort {

    public int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    public int[] sort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = left;

            while (j < i) {
                if (array[j] > array[i]) {
                    var temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }

                j++;
            }
        }

        return array;
    }
}
