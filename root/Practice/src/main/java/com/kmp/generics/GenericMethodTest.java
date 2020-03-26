package com.kmp.generics;

import java.io.FileOutputStream;
import java.io.OutputStream;
@FunctionalInterface
interface I {
    void m1(int i,int j);

    default void m2() {
    }

    boolean equals(Object obj);

    static void m3() {
    }
}

public class GenericMethodTest {

    public static void main(String args[]) {

        I i = (e1,e2) -> {
            System.out.println("First "+e1);
        };
        i.m1(2,3);
        i.m2();
        Thread t = new Thread(GenericMethodTest::m4);
//GenericMethodTest g = new GenericMethodTest();
//       I i = g::m4;
        t.start();
    }

    private static void m4(int i) {

    }

    public static void m4() {
        System.out.println("Thread started....");
    }

}
