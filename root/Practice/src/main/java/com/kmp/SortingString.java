package com.kmp;

import java.util.Arrays;
import java.util.Comparator;

public class SortingString {
    public static void main(String args[]){
        String str = "MAN ALONE, 54 ';:/><.,A";
        String date = "2019-09-06T00:00:00";

        date = date.substring(0, date.indexOf("T"));
        System.out.println(date);
        date = date.replaceAll("-", "");
        System.out.println(date);
        String result = str.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "_");
        System.out.println(result);
//        String sortedString = sortString("KrishnaMurty");
//        System.out.println("Sorted String: "+sortedString);
//
//        System.out.println("Custom Sorting: "+ customSorting("Krishna Murty"));
    }

    private static String sortString(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static String customSorting(String inputString){
        Character[] characters = new Character[inputString.length()];
        for(int i = 0; i<characters.length; i++){
            characters[i] = inputString.charAt(i);
        }

        Arrays.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return Character.compare(Character.toLowerCase(c1),Character.toLowerCase(c2));
            }
        });

        StringBuilder sb = new StringBuilder(characters.length);
        for (Character c: characters
             ) {
            sb.append(c);
        }
        return sb.toString();
    }
}
