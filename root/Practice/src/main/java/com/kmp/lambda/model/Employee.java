package com.kmp.lambda.model;

import java.util.Arrays;
import java.util.Objects;

public class Employee {
    private int Id;
    private String firstName;
    private String lastname;
    private double salary;
    private String department;
    private Address[] addresses;

    public Employee(int Id, String firstName, String lastname, double salary, String department, Address[] addresses) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.salary = salary;
        this.department = department;
        this.addresses = addresses;
    }

    public int getId() {
        return Id;
    }

    public Employee setId(int id) {
        Id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return String.format("%s %s", getFirstName(), getLastname());
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public String toString() {
        return String.format("%-8d %-8s %-8s %-8.2f  %s",
                getId(), getFirstName(), getLastname(), getSalary(), getDepartment());
    }

    /* @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof Employee)) return false;
         Employee employee = (Employee) o;
         return Objects.equals(Id, employee.getId());
     }
*/
    /* @Override
     public int hashCode() {
         int result = Objects.hash(Id, firstName, lastname, salary, department);
         result = 31 * result + Arrays.hashCode(addresses);
         return result;
     }*/

    @Override
    public int hashCode() {
        return firstName.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.getFirstName());
    }
}
