package com.kmp.algorithms.sorting;

import java.util.Arrays;

/**
 * 1. In-Place algorithm i.e. not using extra memory. swapping using input array only
 * 2. O(n2) time complexity - quadratic
 * 3. It will take 100 steps to sort 10 items. 10,000 steps to sort 100 items. So on...
 * 4. Doesn't require as much swapping as bubble sort
 * 5. Unstable algorithm, bcoz it doesn't guarantee the relative position of elements that are having same value.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int intArray[] = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
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
