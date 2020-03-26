package com.kmp.general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciExample {
    static int n1 = 0,n2=1, n3=0;
    public static void main(String args[])  {
        System.out.println("Enter integer number: ");
        try {
            Scanner scanner = new Scanner(System.in);

            int length = scanner.nextInt();
            System.out.println(length);
            System.out.printf(n1 + " " + n2);
            fibonacciRecursive(length - 2);
        }catch(InputMismatchException e){
            System.out.println("Please enter an integer value.");
        }
    }

    private static void fibonacci(int length) {

        int n1 = 0, n2 = 1, n3, i;
        System.out.printf(n1 + " " + n2);
        for (i = 2; length > i; i++) {
            n3 = n1 + n2;
            System.out.printf(" %d",n3);
            n1 = n2;
            n2 = n3;
        }

    }

    private static void fibonacciRecursive(int length){

        if(length > 0){
            n3 = n1+n2;
            n1 = n2;
            n2= n3;
            System.out.print(" "+n3);
            fibonacciRecursive(length-1);
        }
    }
}
