package com.kmp.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class SortingMap {
    public static void main(String[] args) {
        Map<Integer, Student> employeeMap = new HashMap<>();
        employeeMap.put(12, new Student(3, "S3"));
        employeeMap.put(21, new Student(2, "S2"));
        employeeMap.put(4, new Student(4, "S4"));
        employeeMap.put(10, new Student(1, "S1"));
        employeeMap.put(51, new Student(5, "S5"));

        System.out.println("Simple for each");
        for (Map.Entry<Integer, Student> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("Steam on map keys");
        employeeMap.keySet().stream().forEach(System.out::println);

        System.out.println("Steam on map values");
        employeeMap.values().stream().forEach(System.out::println);

        System.out.println("Steam on map itelf");
        employeeMap.forEach((i, j) -> {
            System.out.println(j.getName());
        });

        System.out.println("Steam on List<Student> aka map values");
        List<Student> studentList = new ArrayList<>();
        studentList.addAll(employeeMap.values());

        studentList.stream()
                .forEach(System.out::println);

        System.out.println("Collections.sort on List<Student> with comparator");
        Collections.sort(studentList, new StudentSortByID());
        studentList.stream()
                .forEach(System.out::println);

        System.out.println("Collections.sort on List<Student> with Comparable");
        studentList.removeAll(employeeMap.values());// = new ArrayList<>();
        studentList.addAll(employeeMap.values());
        System.out.println("Before sorting by Comparable");

        studentList.stream()
                .forEach(System.out::println);

        Collections.sort(studentList);
        System.out.println("After sorting by Comparable");

        studentList.stream()
                .forEach(System.out::println);

//We can convert List to Set or Set to List as below
        Set<Student> studentSet = new HashSet<>();
        studentList.addAll(studentSet);
        studentSet.addAll(studentList);
        System.out.println("Sort Student Map by keys (Integer)");
        List<Integer> ids = new ArrayList<>(employeeMap.keySet());
        Collections.sort(ids);

        for (Integer id: ids) {
            System.out.println("ID: "+id +" Student: "+employeeMap.get(id));
        }
    }
}

class Student implements Comparable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return this.getId() - ((Student) o).getId();
    }

    @Override
    public String toString() {
        return String.format("%-8d %-8s",
                getId(), getName());
    }

}

class StudentSortByID implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId() - o2.getId();
    }
}