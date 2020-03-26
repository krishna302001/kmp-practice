package com.kmp.designpattern.creational;

import java.io.Serializable;

public final class SingletonModel extends Object implements Serializable, Cloneable {

    private static volatile SingletonModel singletonModel;
    private static final Object mutex = new Object();
    public String str;

    // private constructor restricted to this class itself
    private SingletonModel() {
        str = "Hello I am a string part of Singleton class";
    }

    /**
     * Local variable result seems unnecessary.
     * But it’s there to improve the performance of our code.
     * In cases where the instance is already initialized (most of the time),
     * the volatile field is only accessed once (due to “return result;” instead of “return instance;”).
     * This can improve the method’s overall performance by as much as 25 percent.
     */
    public static SingletonModel getInstance() {
        SingletonModel result = singletonModel;
        if (result == null) {
            synchronized (mutex) {
                result = singletonModel;
                if (result == null) {
                    result = singletonModel = new SingletonModel();
                }
            }
        }
        return result;
    }


    private Object readResolve() {
        return singletonModel;
    }

    public Object clone() throws CloneNotSupportedException {
//         super.clone();
         return  singletonModel;
    }
}
