package com.kmp.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysAndStreamsInteger {
    private  static  int count = 0;
    public static void main(String args[]) {
        Integer values[] = {3, 5, 9, 8, 6, 7, 2, 1};

        System.out.println("Original values: " + Arrays.toString(values));
        System.out.printf("Sorted values: %s%n",
                Arrays.stream(values)
                        .sorted()
                        .collect(Collectors.toList()));

        List<Integer> greaterThan4 =
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .collect(Collectors.toList());
        System.out.printf("Values greater than 4: %s%n", greaterThan4);

        System.out.printf("Values greater than 4 in sorted order: %s%n",
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .sorted()
                        .collect(Collectors.toList()));

        System.out.printf("greaterThan4 list in sorted order: %s%n", greaterThan4.stream().sorted().collect(Collectors.toList()));

        Collections.synchronizedSet(new HashSet<>());

        for (int i = 0; i < 5; i++) {
            process();
        }
    }

    private static void process () {
        count = 0;

        IntStream stream = IntStream.range(1, 1000);
        //finding the sum of even numbers
        int[] even= stream.parallel()
                .filter(i -> i % 2 == 0)
                .toArray();


//        System.out.printf("sum :%d  count:%d%n", sum, count);


    }
}
