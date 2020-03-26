package com.kmp.lambda;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class CharacterCounter {
    private String name;
    private Integer count;

    public String getName() {
        return name;
    }

    public CharacterCounter setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public CharacterCounter setCount(Integer count) {
        this.count = count;
        return this;
    }
}

public class ArraysAndStreamString {
    public static void main(String args[]) {

        String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "aiolet"};


        System.out.printf("Original strings: %s%n", Arrays.asList(strings));
        System.out.printf("Sorted order: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .sorted()
                        .collect(Collectors.toList()));


                Arrays.stream(strings)
                        .filter(n -> n.startsWith("a"))
                        .collect(Collectors.groupingBy(n-> n, Collectors.counting()))
                        .forEach((k,v) -> System.out.println(k+" "+v));

        System.out.println(Arrays.stream(strings)
                .filter(Filter::filterNameByPrefix)
                .collect(Collectors.toList()));

        System.out.printf("Strings greater than m sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));


        System.out.printf("Strings greater than m sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));
    }
}

class Filter {
    private static String prefix = "a";

    public static boolean filterNameByPrefix(String name) {
        if (name.startsWith(prefix)) {
            return true;
        }
        return false;
    }
}

class StringCounter{
//    public static
}
