package com.kmp.algorithms.sorting;

import java.util.Arrays;

/**
 * 1. In-Place algorithm
 * 2. O(n2) time complexity - quadratic
 * 3. It will take 100 steps to sort 10 items, 10,000 steps to sort 100 items. so on.
 * 4. Algorithm degrades quickly
 */
public class BubbleSort {

    public static void main(String[] args) {
        int intArray[] = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        Arrays.stream(intArray)
                .forEach(System.out::println);
    }

    private static void swap(int[] intArray, int i, int j) {
        if (i == j) {
            System.out.println(intArray[i]+" "+intArray[j]);
            return;
        }
        int temp = intArray[i];
        intArray[i] = intArray[j];
        intArray[j] = temp;
    }
}
