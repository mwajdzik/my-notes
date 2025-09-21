package org.amw061.interview;

import static org.amw061.interview.SearchType.FIRST;
import static org.amw061.interview.SearchType.LAST;

enum SearchType {FIRST, LAST, ANY}

public class BinarySearch {

    public int indexOf(int value, int[] array) {
        return indexOf(value, array, SearchType.ANY);
    }

    public int indexOf(int value, int[] array, SearchType searchType) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int result = -1;

        while (leftIndex <= rightIndex) {
            int middleIndex = (rightIndex + leftIndex) / 2;
            int middleValue = array[middleIndex];

            if (value == middleValue) {
                switch (searchType) {
                    case ANY -> {
                        return middleIndex;
                    }
                    case FIRST -> {
                        result = middleIndex;
                        rightIndex = middleIndex - 1;
                    }
                    case LAST -> {
                        result = middleIndex;
                        leftIndex = middleIndex + 1;
                    }
                }
            } else if (middleValue < value) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }

        return result;
    }

    public int findAllOccurrences(int value, int[] array) {
        int firstOccurrence = indexOf(value, array, FIRST);
        int lastOccurrence = indexOf(value, array, LAST);

        if (firstOccurrence == -1) {
            return 0;
        } else {
            return lastOccurrence - firstOccurrence + 1;
        }
    }
}
