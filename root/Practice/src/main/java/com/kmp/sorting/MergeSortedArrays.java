package com.kmp.sorting;

public class MergeSortedArrays {
    public static void main(String args[]) {
        int a1[] = new int[]{1, 3, 5, 7, 7, 9};
        int a2[] = new int[]{2, 2, 3, 4, 5, 6, 10};

        int a3[] = mergeSortedArrays(a1, a2);
        for (int i = 0; i < a3.length; i++)
            System.out.println(a3[i]);
    }

    private static int[] mergeSortedArrays(int[] a1, int[] a2) {

        int a1l = a1.length, a2l = a2.length, i = 0, j = 0, k = 0;
        int ma[] = new int[a1l + a2l];
        while (a1l > i && a2l > j) {
            if (a1[i] < a2[j]) {
                ma[k] = a1[i];
                i++;

            } else {
                ma[k] = a2[j];
                j++;

            }
            k++;
        }

        if (i < a1.length) {
            System.arraycopy(a1, i, ma, k, a1l - i);
        }

        if (j < a2.length) {
            System.arraycopy(a2, j, ma, k, a2l - j);
        }
        return ma;
    }
}
