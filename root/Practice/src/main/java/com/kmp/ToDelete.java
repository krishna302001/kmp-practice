package com.kmp;

public class ToDelete {
    public static void main(String[] args) {
        int i = 1, j = 1, n = 6;
        System.out.println();
        fbci(i, j, n);

    }

    private static void fbci(int i, int j, int n) {
        if (n > 2) {
            int t = i + j;
            i = j;
            j = t;
            fbci(i, j, n - 1);
            System.out.println(" " + t);

        }

    }
}
