package com.kmp;

/**
 * https://www.geeksforgeeks.org/method-overloading-ambiguity-varargs-java/
 * Method signature consists of method name and arguments types but not return type and it's accessor type
 * You can not define more than one method with the same name, Order and the type of the arguments.
 * It would be compiler error.
 * <p>
 * The compiler does not consider the return type while differentiating the overloaded method.
 * But you cannot declare two methods with the same signature and different return type.
 * It will throw a compile time error. If both methods have same parameter types,
 * but different return type, then it is not possible. (Java SE 8 Edition, §8.4.2)
 */
public class ConstructorChain {

    public static void main(String args[]) {
        // testing constructor chaining in Java
        Derived sub = new Derived("Test");
        Base base = sub;
        base.method1("str");
        method1(3d);
//        method1(null); Ambiguous methods matched method!(int), method1(long), method1(float)
        fun(); // In case of variable length arguments it invokes based on priority byte<short<int<float<long<double
//        fun(null); // Ambiguous

//        method signature consists of method name and arguments types but not return type and it's accessor type
    }

    private static void method1(int i) {
        System.out.println("int: " + i);
    }

    private static void method1(long i) {
        System.out.println("long: " + i);
    }

    private static void method1(double i) {
        System.out.println("float: " + i);
    }

    /*public static int method2(int i) {
        System.out.println("int: " + i);
        return i;
    }

    private static long method2(int i) {
        System.out.println("long: " + i);
        return i;
    }

    private static double method2(int i) {
        System.out.println("float: " + i);
        return i;
    }*/

    //varargs method with float datatype
    static void fun(byte... x) {
        System.out.println("byte varargs");
    }

    //varargs method with int datatype
    static void fun(int... x) {
        System.out.println("int varargs");
    }

    //varargs method with double datatype
    static void fun(short... x) {
        System.out.println("shot varargs");
    }
}

class Base {
    protected String name;

    protected void method1(String str) {
        System.out.println("Base method1");
    }
    /*public Base(){
//        this(""); //calling one arg constructor of same class
        System.out.println("Inside no argument constructor of Base class");
    }*/

    public Base(String name) {
        this.name = name;
        System.out.println("One arg constructor of Base class");
    }
}

class Derived extends Base {
    private static String name;

    public void method1(String str) {
        System.out.println("Derived method1");
    }

    public Derived() {
        super("sdf");
        System.err.println("Inside no argument constructor of Derived class");
    }

    public Derived(String name) {
        super(name); //calling one argument constructor of super class
        System.out.println("Inside one arg constructor from Derived class");
    }
}