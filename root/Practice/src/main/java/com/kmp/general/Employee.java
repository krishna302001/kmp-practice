package com.kmp.general;

public class Employee implements Cloneable{

    private String city;

    public Employee employeeClone() throws CloneNotSupportedException{
        Employee clonedEmployee = (Employee) super.clone();
        return clonedEmployee;
    }

}
