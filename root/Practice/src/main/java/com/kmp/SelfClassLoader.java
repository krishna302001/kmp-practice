package com.kmp;

public class SelfClassLoader {
    private SelfClassLoader(){}
    public static void main(String args[]){
        try {
            Class cls = Class.forName("com.kmp.SelfClassLoader");
            SelfClassLoader instance = (SelfClassLoader)cls.newInstance();
            instance.method1();
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
    private void method1(){
        System.out.println("HI");
    }
}
