package org.amw061.interview.divide_conquer;

import org.amw061.interview.sorting.InsertionSort;

import static java.util.Arrays.copyOfRange;

public class MergeSort {

    private static final InsertionSort INSERTION_SORT = new InsertionSort();
    private static final int INSERTION_SORT_COUNT = 10;

    public int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int left, int right) {
//        if (right - left == 0) {
//            return;
//        } else if (right - left == 1) {
//            swap(array, left, left + 1);
//        } else if (right - left == 2) {
//            sortThreeItems(array, left);
//        }

        if (right - left <= INSERTION_SORT_COUNT) {
            INSERTION_SORT.sort(array, left, right);
            return;
        }

        int middle = (left + right) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        merge(array, left, right, middle);
    }

    private void sortThreeItems(int[] array, int i) {
        if (array[i] > array[i + 1]) swap(array, i, i + 1);
        if (array[i + 1] > array[i + 2]) swap(array, i + 1, i + 2);
        if (array[i] > array[i + 1]) swap(array, i, i + 1);
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    private void merge(int[] array, int left, int right, int middle) {
        int index = left;

        int[] leftHalf = copyOfRange(array, left, middle + 1);
        int[] rightHalf = copyOfRange(array, middle + 1, right + 1);

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftHalf.length && rightIndex < rightHalf.length) {
            if ((leftHalf[leftIndex] <= rightHalf[rightIndex])) {
                array[index] = leftHalf[leftIndex];
                leftIndex++;
            } else {
                array[index] = rightHalf[rightIndex];
                rightIndex++;
            }

            index++;
        }

        while (leftIndex < leftHalf.length) {
            array[index++] = leftHalf[leftIndex++];
        }

        while (rightIndex < rightHalf.length) {
            array[index++] = rightHalf[rightIndex++];
        }
    }
}
