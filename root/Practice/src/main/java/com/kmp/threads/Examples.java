package com.kmp.threads;

public class Examples {
    public static void main(String[] args) {
        Examples examples = new Examples();
//        examples.new InnerClass();

        InnerClass innerClass1 = new InnerClass();
        InnerClass innerClass2 = new InnerClass();
        if(innerClass1==innerClass2){
            System.out.println("Yes");
        }else
        {
            System.out.println("No");
        }
    }


     static class InnerClass{
        private void m1(){
            System.out.println("inner class m1");
        }
         public void m2(){
             System.out.println("inner class m1");
         }
    }
}
