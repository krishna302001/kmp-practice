package com.kmp.general;

import java.io.InputStream;

public class StreamReader {

    public static void main(String args[]) {
        StreamReader sr = new StreamReader();
        sr.method1();

        /*Scanner sc = new Scanner(System.in);
        int number = Integer.MAX_VALUE;
        System.out.println("Enter an integer to check if it's prime or not: ");
        while(number!=0){
            number = sc.nextInt();
            System.out.printf("Does %d is prime? %s",number, isPrime(number));
        }*/


    }

    public void method1() {
        InputStream is = StreamReader.class.getClass().getResourceAsStream("path/resource.xml");
        if (is == null) {
            System.out.println("IntStreamOperations is null1");
        }
        is = StreamReader.class.getResourceAsStream("path/resource.xml");
        if (is == null) {
            System.out.println("IntStreamOperations is null2");
        }
        System.out.println(StreamReader.class.getClassLoader().getClass().getName());
        System.out.println(getClass().getClassLoader().getClass().getName());
        is = getClass().getResourceAsStream("path/resource.xml");
        if (is == null) {
            System.out.println("IntStreamOperations is null3");
        }

    }

    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        System.out.println(Math.sqrt(number));
        System.out.println((int) Math.sqrt(number));
        System.out.println(sqrt);
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                System.out.printf("dived by %s\n", i);
                return false;
            }
        }
        return true;
    }

    public static String isPrimeOrNot(int num) {
        if (num < 0) {
            return "not valid";
        }
        if (num == 0 || num == 1) {
            return "not prime";
        }
        if (num == 2 || num == 3) {
            return "prime number";
        }
        if ((num * num - 1) % 24 == 0) {
            return "prime";
        } else {
            return "not prime";
        }
    }
}
