package org.amw061.interview.dynamic_programming;

import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weights = new int[]{0, 3, 2, 7, 9, 4};
        int[] values = new int[]{0, 10, 20, 15, 30, 6};
        int capacity = 10;
        int items = 5;

        System.out.println("Recursive result: " + recursive(capacity, weights, values, items) + "\n");

        int[][] array = prepareDynamicProgrammingArray(values, capacity);
        dynamicProgramming(array, capacity, weights, values);
        printArray(array, weights, values);
    }

    private static int recursive(int capacity, int[] weights, int[] values, int n) {
        if (capacity == 0 || n == 0) {
            return 0;
        }

        if (weights[n] > capacity) {
            return recursive(capacity, weights, values, n - 1);
        }

        int itemIncluded = values[n] + recursive(capacity - weights[n], weights, values, n - 1);
        int itemExcluded = recursive(capacity, weights, values, n - 1);

        return Math.max(itemIncluded, itemExcluded);
    }

    private static void dynamicProgramming(int[][] array, int capacity, int[] weights, int[] values) {
        for (int subsetSize = 1; subsetSize < array.length; subsetSize++) {
            for (int subproblemCapacity = 1; subproblemCapacity <= capacity; subproblemCapacity++) {
                int previousCapacity = subproblemCapacity - weights[subsetSize];

                int valueWhenItemExcluded = array[subsetSize - 1][subproblemCapacity];
                int valueWhenItemIncluded = previousCapacity < 0 ? valueWhenItemExcluded : values[subsetSize] + array[subsetSize - 1][previousCapacity];

                array[subsetSize][subproblemCapacity] = Math.max(valueWhenItemIncluded, valueWhenItemExcluded);
            }
        }
    }

    private static void printArray(int[][] array, int[] weights, int[] values) {
        for (int subsetSize = 1; subsetSize < values.length; subsetSize++) {
            String subset = stream(values)
                    .mapToObj(String::valueOf)
                    .skip(1).limit(subsetSize)
                    .collect(Collectors.joining(", "));

            System.out.printf("[%-20s] ", subset);

            for (int subproblem = 1; subproblem < array[subsetSize].length; subproblem++) {
                System.out.printf("%6s", array[subsetSize][subproblem]);
            }

            System.out.println();
        }
    }

    private static int[][] prepareDynamicProgrammingArray(int[] values, int capacity) {
        int[][] array = new int[values.length][capacity + 1];
        for (int i = 0; i < capacity + 1; i++) {
            array[0][i] = 0;  // with no items we get value of 0
        }

        for (int j = 0; j < values.length; j++) {
            array[j][0] = 0;  // empty subset of any subset of values has a value of 0
        }
        return array;
    }
}
