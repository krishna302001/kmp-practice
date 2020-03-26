package com.kmp.general;

import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.io.Serializable;

/**
 *
 * Java program to demonstrate What is transient variable in Java and fact that value of
 * transient variable is not serialized and during serialization it initialized with
 * default value of that data type. e.g. If transient variable is Object than after
 * deserialization its value would be null.
 *
 */
public class TransientTest {


    public static void main(String args[]) {

        Book narnia = new Book(1024, "Narnia", "unknown", 2);
        System.out.println("Before Serialization: " + narnia);

        try {
            FileOutputStream fos = new FileOutputStream("narnia.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(narnia);

            System.out.println("Book is successfully Serialized ");

            FileInputStream fis = new FileInputStream("narnia.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Book oldNarnia = (Book) ois.readObject();

            System.out.println("Book successfully created from Serialized data");
            System.out.println("Book after seriazliation : " + oldNarnia);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*
 * A class which implements Serializable interface and has a transient variable.
 */
class Book implements Serializable{
    private int ISBN;
    private String title;
    private String author;
    private transient int edition = 1; //transient variable not serialized

    public Book(int ISBN, String title, String author, int edition) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book{" + "ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", edition=" + edition + '}';
    }

}
