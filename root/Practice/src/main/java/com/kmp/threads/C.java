package com.kmp.threads;

public class C {
    public static void main(String[] args) {
        I i = new B();
        I.m1();         // Invoking static method of Interface I
        ((B)i).m2();    // Invoking non-static method of class B
        i.m3();         // Invoking non-static method of class B derived from I
        ((B) i).m4();   // Invoking static method of class B that is not defined in Interface I
        B.m4();         // Invoking static method of class B directly
        ((B)i).m5();    // Invoking non-static method of class B using interface object i
//        Thread t = B::m3;
//        Thread t1 = new Thread(B::m1);
//        Thread t3 = new Thread(B::m3);
    }

}

class R implements Runnable {
    public void run() {
    }
}

class B implements I {
    public void m1() {
        System.out.println("B m1");
    }

    public void m2() {
        System.out.println("B m2");
    }

    public void m3() {
        System.out.println("B m3");
    }

    public static void m4() {
        System.out.println("B m4");
    }
    public void m5(){
        System.out.println("B m5");
    }
}
