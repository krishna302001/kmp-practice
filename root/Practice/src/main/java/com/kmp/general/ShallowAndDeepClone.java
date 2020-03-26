package com.kmp.general;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * If there's a member variables in Class then == method do simply shallow compare.
 * If you compare member variables inside an object then it's called deep compare.
 *
 * Use Copy Constructor over Cloneable interface.
 * https://www.programmingmitra.com/2017/01/Java-cloning-copy-constructor-versus-Object-clone-or-cloning.html
 * Advantages of copy constructors over Object.clone()::
 * Copy constructors are better than Object.clone() because they
 * Don’t force us to implement any interface or throw any exception but we can surely do it if it is required.
 * Don’t require any casts.
 * Don’t require us to depend on an unknown object creation mechanism.
 * Don’t require parent class to follow any contract or implement anything.
 * Allow us to modify final fields.
 * Allow us to have complete control over object creation, we can write our initialization logic in it.
 */
public class ShallowAndDeepClone implements Cloneable {
    private String name;
    private String agae;
    private Employee employee;
    public static void main(String args[]) {
        System.out.println("hi");
    }

    public ShallowAndDeepClone myclone() throws CloneNotSupportedException {
        ShallowAndDeepClone cloneObject = (ShallowAndDeepClone) super.clone();
        cloneObject.employee = this.employee.employeeClone();
        return cloneObject;
    }
}
