package com.kmp.designpattern.creational;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class TestSingletonSerializationNReflectionNCloning extends Object{
    public static void main(String[] args) throws IOException {
        //Deseriablization should not break singleton object
        checkDeserializationOfSingleton();

        cloneSingleton();
        /**
         * We can break singleton using Reflection.
         * Use Enum for Singleton because newInstance() throws exception for Enum
         */
        checkReflection();
    }

    private static void cloneSingleton() {

        SingletonModel singletonModel = SingletonModel.getInstance();
        SingletonModel clonedSingleton = null;
        try {
            clonedSingleton = (SingletonModel) singletonModel.clone();
        } catch (CloneNotSupportedException cse) {
            System.out.println("CloneNotSupportedException: " + cse.getMessage());
        }
        if (singletonModel == clonedSingleton) {
            System.out.println("Cloned object is same as Singleton Object");
        } else {
            System.out.println("Cloned object is NOT same as Singleton Object");
        }
    }

    private static void checkReflection() {
        SingletonModel singletonModel = SingletonModel.getInstance(), singletonReflection = null;

        Constructor<?> constructor = SingletonModel.class.getDeclaredConstructors()[0];
        try {
            constructor.setAccessible(true);
            singletonReflection = (SingletonModel) constructor.newInstance();
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        if (singletonModel == singletonReflection) {
            System.out.println("Singleton object are same after Reflection");
        } else {
            System.out.println("Singleton object NOT are same after Reflection");
        }
    }

    private static void checkDeserializationOfSingleton() throws IOException {
        SingletonModel singletonModel = SingletonModel.getInstance();
        FileOutputStream fs = null;
        ObjectOutputStream outputStream = null;
        try {
            fs = new FileOutputStream("file.txt");
            outputStream = new ObjectOutputStream(fs);
            outputStream.writeObject(singletonModel);
            System.out.println("Hashcode before serialization: "+singletonModel.hashCode());
        } catch (IOException ie) {
            System.out.println("IOException: " + ie.getMessage());
        } finally {
            if (null != fs)
                fs.close();
            if (null != outputStream)
                outputStream.close();
        }
        SingletonModel deserialized = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream inputStream = null;
        try {
            fileInputStream = new FileInputStream("file.txt");
            inputStream = new ObjectInputStream(fileInputStream);
            deserialized = (SingletonModel) inputStream.readObject();
            System.out.println("Hashcode after serialization: "+singletonModel.hashCode());
        } catch (ClassNotFoundException cnf) {
            System.out.println("ClassNotFoundException: " + cnf.getMessage());
        } finally {
            if (null != fileInputStream)
                fileInputStream.close();
            if (null != inputStream)
                inputStream.close();
        }
        if (deserialized == singletonModel) {
            System.out.println("Singleton objects are same after deserialization");
        } else {
            System.out.println("Singleton objects are NOT same after deserialization");
        }
    }
}
