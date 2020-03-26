package com.kmp.lambda;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class IntStreamOperations {
    public static void main(String args[]) {

        int[] values = {2, 4, 61, 65, 1, 3, 8, 9};

        IntStream.of(values).forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        IntStream.of(values).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.printf("%d ", value);
            }
        });


        System.out.println();
        System.out.printf("Count: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n", IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n", IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n", IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n", IntStream.of(values).average().getAsDouble());


        System.out.printf("%nSum using reduce method: %d", IntStream.of(values).reduce(0, (x, y) -> x + y));

        System.out.printf("%nSum of squares using reduce method: %d", IntStream.of(values).reduce(0, (x, y) -> x + y * y));

        System.out.printf("%nProduct using reduce method: %d%n", (IntStream.of(values).reduce((x, y) -> x * y).getAsInt()));

        System.out.printf("%nEven values displayed in sorted order: ");
        IntStream.of(values)
                .filter(value -> value % 2 == 0)
                .sorted()
                .forEach(value -> System.out.printf("%d ", value));

        System.out.println();

        System.out.printf("Odd values mutliplied by 10 diplayed in sorted order: ");
        IntStream.of(values)
                .filter(value -> value % 2 != 0)
                .map(value -> value * 10)
                .sorted()
                .forEach(value -> System.out.printf("%d ", value));

        System.out.println();

        System.out.printf("%n Sum of integers from 1 to 9: %d%n",
                IntStream.range(1, 10)
                        .sum());

        System.out.printf("%n Sum of integers from 1 to 10: %d%n",
                IntStream.rangeClosed(1, 10)
                        .sum());

    }


}
