package org.amw061.interview.dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class SubsetSumProblem {

    public static void main(String[] args) {
        int[] items = new int[]{0, 5, 3, 2, 1};
        int sum = 10;

        recursive(items, sum, items.length - 1);

        boolean[][] array = prepareDynamicProgrammingArray(items, sum);
        dynamicProgramming(array, items);
        printArray(array, items);
        printResult(array, items, sum);
    }

    private static boolean recursive(int[] items, int sum, int n) {
        if (sum == 0) {
            return true;
        }

        if (n == 0 && sum > 0) {
            return false;
        }

        boolean itemIncluded = sum - items[n] >= 0 && recursive(items, sum - items[n], n - 1);
        boolean itemExcluded = recursive(items, sum, n - 1);

        return itemIncluded || itemExcluded;
    }

    private static void dynamicProgramming(boolean[][] array, int[] items) {
        for (int subsetSize = 1; subsetSize < array.length; subsetSize++) {
            for (int subproblemSum = 1; subproblemSum < array[subsetSize].length; subproblemSum++) {
                int previousSum = subproblemSum - items[subsetSize];
                boolean itemIncluded = previousSum >= 0 && array[subsetSize - 1][previousSum];
                boolean itemExcluded = array[subsetSize - 1][subproblemSum];

                array[subsetSize][subproblemSum] = itemIncluded || itemExcluded;
            }
        }
    }

    private static void printResult(boolean[][] array, int[] items, int sum) {
        int subsetSize = items.length - 1;
        List<Integer> result = new ArrayList<>();

        while (sum > 0 && subsetSize > 0) {
            if (array[subsetSize][sum] != array[subsetSize - 1][sum]) {
                result.add(items[subsetSize]);
                sum -= items[subsetSize];
            }

            subsetSize--;
        }

        if (!result.isEmpty()) {
            System.out.println("Result: " + result);
        }
    }

    private static void printArray(boolean[][] array, int[] items) {
        for (int subsetSize = 1; subsetSize < items.length; subsetSize++) {
            String subset = stream(items)
                    .mapToObj(String::valueOf)
                    .skip(1).limit(subsetSize)
                    .collect(Collectors.joining(", "));

            System.out.printf("[%-11s] ", subset);

            for (int subproblem = 1; subproblem < array[subsetSize].length; subproblem++) {
                System.out.printf("%6s", array[subsetSize][subproblem]);
            }

            System.out.println();
        }
    }

    private static boolean[][] prepareDynamicProgrammingArray(int[] items, int sum) {
        boolean[][] array = new boolean[items.length][sum + 1];
        for (int i = 0; i < sum + 1; i++) {
            array[0][i] = false; // with no items we cannot get sum > 0
        }

        for (int j = 0; j < items.length; j++) {
            array[j][0] = true;  // empty subset of any subset of items has a sum of 0
        }
        return array;
    }
}
