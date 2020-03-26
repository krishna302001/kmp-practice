package com.kmp.lambda;

import com.kmp.lambda.model.Address;
import com.kmp.lambda.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingEmployees {

    public static void main(String args[]) {
        Address[] addresses1 = {
                new Address("PUNE", 411028, "MH"),
                new Address("Hyderabad", 52342, "AP")
        };

        Address[] addresses2 = {
                new Address("Jaipur", 411028, "RJ"),
                new Address("Hyderabad", 52342, "AP")
        };
        Employee[] employees = {
                new Employee(1, "Jason", "Red", 5000, "IT", addresses1),
                new Employee(2, "Ashley", "Green 1", 7600, "IT", addresses2),
                new Employee(3, "Ashley", "Green 2", 7600, "IT", addresses2),
                new Employee(4, "Matthew", "Indigo", 3587.5, "Sales", addresses1),
                new Employee(5, "James", "Indigo", 4700.77, "Marketing", addresses1),
                new Employee(6, "Luke", "Indigo", 6200, "IT", addresses1),
                new Employee(7, "Ashley", "Blue", 3200, "Sales", addresses1),
                new Employee(8, "Wen1dy", "Brown", 4236.4, "Marketing", addresses2)
        };

        List<Employee> list = Arrays.asList(employees);
Stream<Address> asdf = list.stream()
        .flatMap(e ->Stream.of(e.getAddresses()));
        System.out.println(list);
        Set<String> cities =
                list.stream()
//                        .map(employee -> Arrays.stream(employee.getAddresses()))
                        .flatMap(employee -> Arrays.stream(employee.getAddresses()))
                        .map(address -> address.getCity())
                        .collect(Collectors.toSet());
//                .forEach(System.out::println);

        Map<Employee, String> employeeMap = new HashMap<>();
        employeeMap.put(list.get(0), "1");
        employeeMap.put(list.get(1), "2");
        employeeMap.put(list.get(2), "3");

       /* Map<String, List<Employee>> s = list.stream()
                .collect(Collectors.toMap(c -> c, Employee::getName));*/
        /*list.stream()
                .collect(Collectors.toMap(Employee::getName, c -> c));*/
        for (Employee emp : employeeMap.keySet()) {
            System.out.println(emp);
        }

        System.out.println("Complete Employee list");
        System.out.println();
        list.stream().forEach(System.out::println);

        Predicate<Employee> fourToSixThousand = employee -> (employee.getSalary() > 4000 && employee.getSalary() < 6000);

        System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary: %n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

       /* System.out.printf("%nFirst employee with salary range > 9000: %n%s%n",
                list.stream()
                        .filter(e -> e.getSalary() > 9000)
                        .findFirst().orElse(new Employee("New employee", "New Lastname", 343, "SomeDepartment")));

        System.out.printf("%nFirst employee with salary in range $4000-$6000: %n%s%n",
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst().orElse(new Employee("No employee", "df", 343, "ddf")));*/

        ProcessingEmployees.functionsAndComparator(list);
        ProcessingEmployees.mappingAndUniqueLast(list);
        ProcessingEmployees.grouping(list);
        ProcessingEmployees.SummingAndAveraging(list);
    }

    private static void functionsAndComparator(List<Employee> list) {
        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastname;

        //Comparator for comparing Employees by last name then first name
        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

        //Sort employees by last name, then first name
        System.out.printf("%nEmployees in ascending order by last name then first: %n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        //Sort employees by last name, then first name
        System.out.printf("%nEmployees in descending order by last name then first: %n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

    }

    private static void mappingAndUniqueLast(List<Employee> list) {
        //Display unique employee last names sorted
        System.out.printf("%nDisplay unique employee last names sorted: %n");
        list.stream()
                .map(Employee::getLastname)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        //Display only first and last names
        System.out.printf("%nEmployees in order by last name then first name: %n");
        list.stream()
                .sorted(Comparator.comparing(Employee::getLastname).thenComparing(Employee::getFirstName))
                .map(Employee::getName)
                .forEach(System.out::println);

    }

    private static void grouping(List<Employee> list) {
        Map<String, List<Employee>> groupByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.printf("%nGroup by department:%n");
        groupByDepartment.forEach((department, employeeDepartment) -> {
            System.out.println(department);
            employeeDepartment.forEach(employee -> System.out.printf("  %s%n", employee));
        });


        //Count number of Employees in each department
        System.out.printf("%nEmployee count in each department:%n");
        Map<String, Long> employeeCountByDepartment = list.stream()
                .collect((Collectors.groupingBy(Employee::getDepartment,
                        TreeMap::new, Collectors.counting())));
        employeeCountByDepartment.forEach(
                (department, count) -> System.out.printf(
                        "%s has %d employees%n", department, count)
        );
    }

    private static void SummingAndAveraging(List<Employee> list) {
        System.out.printf("%nSum of Emp salaries (via sum method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum());

        System.out.printf("Sum of Emp salaries (via reduce method): %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .reduce(0, (value1, value2) -> value1 + value2));

        System.out.printf("Average of Emp salaries: %.2f%n",
                list.stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble());
    }
}
