package com.kmp;

import java.util.HashMap;
import java.util.Map;

public class MutableExample {
    static HashMap<Integer, String> hm = new HashMap<>();

    //    get
    public static void main(String args[]) {

        hm.put(1, "One");

        shallowCopy(hm);
        System.out.println(hm);
    }

    private static void shallowCopy(HashMap<Integer, String> hm) {
        Map<Integer, String> newObject = new HashMap<>();
        newObject = hm;
        newObject.put(1, "three");

//        HashMap<Integer, String> copy = hm;
//        copy.put(1,"two");
//        System.out.println(copy);
        System.out.println(newObject);
    }
}
