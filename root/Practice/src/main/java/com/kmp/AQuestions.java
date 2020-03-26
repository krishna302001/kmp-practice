package com.kmp;

import com.kmp.lambda.model.DummyObject;

import java.math.BigInteger;

public class AQuestions {
    public static void main(String[] args) {
        // 1
        bigIntegerExample();

        // 2
        int x = -4, y = 2, z = 0, m;
        m = ++x | ++y & z++;
        System.out.println(x + " " + y + " " + z + " " + m);

        // 3
        System.out.println(isTrue());

        // 4
        Null nullObject = new Null();
//        (null)(nullObject).method(); // Java not a statement. Compile time error
//        (Null)null.method(); // Java not a statement. Compile time error

        // 5
        StaticVariable staticVariable1 = new StaticVariable();
        StaticVariable staticVariable2 = new StaticVariable();
        StaticVariable staticVariable3 = new StaticVariable();
        System.out.println("staticVariable2: " + staticVariable2.num + " staticVariable3: " + staticVariable3.num);

        //6

        DummyObject dummyObject1 = new DummyObject();
        dummyObject1.setValue("dummy");
        DummyObject dummyObject2 = new DummyObject();
        dummyObject2.setValue("dummy1");
        System.out.println(dummyObject1.equals(dummyObject2));
        System.out.println(dummyObject1.hashCode() + " " + dummyObject2.hashCode());

        // 7

        System.out.println("factorial using Recursion: " + factorialRecursion(6));

        //8 Class example
        classExample();

        // Have we used Tree data structure in JDK ? Answer is NO


    }

    private static void classExample() {
        String str = "abc";
        Class c = str.getClass();
    }

    private static void bigIntegerExample() {
        BigInteger zero = BigInteger.ZERO;
        BigInteger bi1 = new BigInteger("5000");
        BigInteger bi2 = new BigInteger("50000");
        BigInteger bi3 = bi1.add(bi2);
        System.out.println(zero);
        System.out.println(bi1);
        System.out.println(bi2);
        System.out.println(bi3);
    }

    static boolean isTrue() {
        try {
            return true;
        } finally {
            return false;
        }
    }

    static int factorialRecursion(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorialRecursion(num - 1);
    }

}

class Null {
    public void method() {
        System.out.println("Inside Null class method.");
    }
}

class StaticVariable {
    static int num = 10;

    StaticVariable() {
        num += 1;
    }
}

