package com.kmp.lambda;

public class LambdaExample {

    public static void main(String args[]) {
        Book book1 = name -> System.out.println("Reading " + name);
        Book b3 = new Book() {
            @Override
            public void read(String name) {
                System.out.println("Reading b3 " + name);
            }
        };
        book1.read("Krishna");
        b3.read("KMP");
    }

    interface Book {
        void read(String name);
    }
}
