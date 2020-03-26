package com.kmp;

import java.util.HashMap;
import java.util.Map;

class Employee {

    String name;

    public Employee(String nm) {
        this.name=nm;
    }
}

public class HashMapKeyNullValue {

    Employee e1;

    public void display(){

        Employee e2=null;
        Map map=new HashMap();

        map.put(e2, "25");
        System.out.println("Getting the Value When e2 is set as KEY");
        System.out.println("e2 : "+map.get(e2));
//        System.out.println("e1 : "+map.get(e1));
        System.out.println("null : "+map.get(null));

        map.put(e1, "");
        System.out.println("Getting the Value when e1 is set as KEY");
        System.out.println("e2 : "+map.get(e2));
        System.out.println("e1 : "+map.get(e1));
        System.out.println("null : "+map.get(null));

        map.put(null, null);   // null as key and null as value
        System.out.println("Getting the Value when setting null as KEY and null as value");
        System.out.println("e2 : "+map.get(e2));
        System.out.println("e1 : "+map.get(e1));
        System.out.println("null : "+map.get(null));

        map.put(null, "30");
        System.out.println("Getting the Value when setting only null as KEY");
        System.out.println("e2 : "+map.get(e2));
        System.out.println("e1 : "+map.get(e1));
        System.out.println("null : "+map.get(null));
    }

    public static void main(String[] args) {

        new HashMapKeyNullValue().display();

        HashMap<Integer,String> map=new HashMap<Integer,String>();
        map.put(null, "abc"); // hashcode for null is 0.
        map.put(0, "xyz"); // will it override the value for null as key?

        System.out.println(map.get(null));  // abc
        System.out.println(map.get(0));
    }
}
