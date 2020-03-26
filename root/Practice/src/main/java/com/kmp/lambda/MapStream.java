package com.kmp.lambda;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MapStream {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add(null);
        list1.add("C");
        System.out.println(list1);

        System.out.println((int)list1.stream()
                .filter(e->e!=null)
                .count());
        System.out.println();
        /*list.stream().map(i ->i*2)
                .forEach(System.out::println);
*/
        list.stream().flatMap(i -> Stream.of(i * 2, i * 3))
                .forEach(System.out::println);

       /* list.stream().collect(Collectors.toMap(i->i, i -> {
            Date today = new Date();
            SimpleDateFormat DATE_FORMAT =  new SimpleDateFormat("dd-MM-yy HH:mm:SS");
            String date = DATE_FORMAT.format(today);
            return date;
            }, (o1, o2)-> o1))
        .forEach((a,b)->System.out.printf("Key: "+a +" Value: "+b +"%n"));*/

//        list.stream().collect();
    }
}
