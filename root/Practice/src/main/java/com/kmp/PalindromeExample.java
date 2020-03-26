package com.kmp;

public class PalindromeExample {
    public static void main(String[] args) {
        String input = "ABCBAA";
        if (checkPalindrome(input)) {
            System.out.println("Yes palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }

    private static boolean checkPalindrome(String input) {
        for (int i = 0, j = input.length() - 1; i < input.length() / 2; i++, j--) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
