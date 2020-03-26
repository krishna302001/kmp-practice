package com.kmp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

class  I {
    static void say(){
        System.out.println("hi");
    }
}
public class A extends AbstractInterface {

    private final float pie = 3.14f;
    static void say(){
        System.out.println("hi");
    }

    public static void main(String args[]) throws FileNotFoundException {
        A a = new A();
        System.out.println(a.toString());
//        AbstractInterface ab = new AbstractInterface() ;

        AutoCloseable ac = I::say;

        ThreadLocal<String> tl = new ThreadLocal<String>(){
            @Override
            protected String initialValue(){
                return "hi";
            }
        };

//        tl.set("hi");
        System.out.println(tl.get());
        check();

    }

    private float area(int r){
        return (float) (pie*r*2);
    }

    @Override
    void method2() {

    }

    @Override
    public String toString() {
        return objString();
    }

    public enum Gender {
        MALE, FEMALE, OTHERS
    }

    public static void  check(){
        Arrays.stream(Gender.values()).forEach(System.out::println);
    }
}
