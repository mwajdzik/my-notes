package org.amw061.interview;

public class QuickSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int left, int right) {
        if (left < right) {
            int pivotPos = partition(array, left, right);
            sort(array, left, pivotPos - 1);
            sort(array, pivotPos + 1, right);
        }
    }

    public int partition(int[] array, int left, int right) {
        int pivotValue = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivotValue) {
                i++;
                swap(array, i, j);
            }
        }

        int pivotPosition = i + 1;
        swap(array, pivotPosition, right);
        return pivotPosition;
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }
}
