package com.kmp;

/**
 * If there's a single abstract method then it's mandatory to declare class as abstract.
 * Vice versa is possible.
 */
public abstract class AbstractInterface {
    void method1() {
    }

    public AbstractInterface() {
    }

    abstract void method2();

    public abstract   String toString();

    protected String objString() {
        return super.toString();
    }
}
