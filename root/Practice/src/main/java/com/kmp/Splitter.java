package com.kmp;

public class Splitter {
    public static void main(String args[]) {
        String str = "asdf;sdfsdf;sdfsdsdgtstg;;";
        String[] attr = str.split(";");
        System.out.println(attr.length);
        for(int i=0; i<attr.length;i++){
            System.out.println(attr[i]);
        }

        double i ;
        int  j=4,k=5;
        i = (double)j/k;
        System.out.println(i);
        System.out.println(Math.floor(i));

    }

}
