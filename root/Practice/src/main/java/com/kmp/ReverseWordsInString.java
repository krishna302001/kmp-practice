package com.kmp;

public class ReverseWordsInString {
    private static String input = "Hello World!";

    public static void main(String args[]) {
        System.out.println(reverseStringWords(input));
        System.out.println(reverseString(input));
    }

    //Multiple for loop
    private static String reverseStringWords(String input) {

        String wordArray[] = input.split(" ");
        String output = "";

        for (int i = 0; i < wordArray.length; i++) {
            String word = wordArray[i], revWord = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                revWord = revWord + c;
            }
            output = output + revWord + " ";
        }
        return output;
    }

    //Singe for loop
    private static String reverseString(String input) {
        String output = "";
        String revWord = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c == ' ') {
                output = " " + revWord + output;
                revWord = "";
            }
            revWord = revWord + c;
        }
        output = revWord + output;
        return output.trim();
    }
}
