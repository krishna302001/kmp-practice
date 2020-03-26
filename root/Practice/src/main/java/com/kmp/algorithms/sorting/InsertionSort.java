package com.kmp.algorithms.sorting;

import java.util.Arrays;

/**
 * 1. In-place algorithm
 * 2. O(n2) time complexity
 * 3. It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items. so on.
 * 4. Stable algorithm because it does guarantee the relative position of elements that are having same value.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int intArray[] = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }

        Arrays.stream(intArray)
                .forEach(System.out::println);
    }
}
