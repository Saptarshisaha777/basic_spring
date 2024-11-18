package com.learn.java8.basics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamLearn {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 18,1000.23 ,Department.FINANCE));
        employees.add(new Employee("Pete", 20,2000.23  ,Department.PRODUCTS));
        employees.add(new Employee("Mark", 30,3000.23  ,Department.HR));
        employees.add(new Employee("John", 40 ,4000.23  ,Department.ENGINEERING));
        employees.add(new Employee("Pete", 19,5000.23  ,Department.PRODUCTS));
        employees.add(new Employee("Mark", 29,6000.23  ,Department.SALES));
        for(Employee e:employees){
            System.out.println(e.getName() + " " + e.getSalary());
        }

        System.out.println("\n \nSorting in descending order of Salary");
        List<Employee> newList = employees.stream()
                .sorted((a,b)->(int)(b.getSalary()- a.getSalary()))
                .toList();

        for(Employee e:newList){
            System.out.println(e.getName() + " " + e.getSalary());
        }

        System.out.println("\n \nSorting in descending order of Salary & fetching top 3");
        newList = employees.stream()
                .sorted((a,b)->(int)(b.getSalary()- a.getSalary()))
                .limit(3)
                .toList();

        for(Employee e:newList){
            System.out.println(e.getName() + " " + e.getSalary());
        }

        System.out.println("\n \nSorting in descending order of Salary & fetching skipping top 3");
        newList = employees.stream()
                .sorted((a,b)->(int)(b.getSalary()- a.getSalary()))
                .skip(3)
                .toList();

        for(Employee e:newList){
            System.out.println(e.getName() + " " + e.getSalary());
        }

        System.out.println("\n \nFinding the employee with max salary below 20 years");
Employee maxSalaryEmployee = employees.stream()
    .filter(e -> e.getAge() < 20)
    .min((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
    .orElseThrow();

    System.out.println(maxSalaryEmployee.toString());

    int[] quantities = {1,7,3,4,5};
    int max = Arrays.stream(quantities).max().getAsInt();
    System.out.println(max);

        System.out.println("\n \nFinding the employee with max salary depending on department");

        // groupingBy() is a collector that groups the input elements of a stream into a Map based on a classification function.
        // mapping() is a collector that applies a function to each input element and returns a new stream consisting of the results.
        // collectingAndThen() is a collector that applies a function to each input element and returns a new stream consisting of the results.
        // Collectors.maxBy is a collector that returns the maximum element of this stream according to the provided Comparator.
        Map<Department, Double> employeegrp = employees.stream()
            .collect(
                    Collectors.groupingBy(Employee::getDepartment,
                            Collectors.collectingAndThen(
                                    Collectors.mapping(Employee::getSalary,
                                                        Collectors.maxBy(Comparator.naturalOrder())),
                                    obj -> obj.orElse(0.0))));

                    for(Department d : employeegrp.keySet()){
                        System.out.println("Department:"+d +" ,maxSalary: "+employeegrp.get(d));
                    }

        System.out.println("\n \nFinding  average salary depending on department");
        employeegrp = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));

        for(Department d : employeegrp.keySet()){
            System.out.println("Department:"+d +" ,maxSalary: "+employeegrp.get(d));
        }
        ///

        ///
        System.out.println("\n \nFinding  average salary depending on department");
        employeegrp = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));

        for(Department d : employeegrp.keySet()){
            System.out.println("Department:"+d +" ,maxSalary: "+employeegrp.get(d));
        }

        System.out.println("\n \nFinding  all distinct names Employees");
        List<String> duplicateNames = employees.stream().map(Employee::getName).distinct()
                .collect(Collectors.toList());

        System.out.println(duplicateNames);

        //find prime
        int num = 100;
        System.out.println(String.format("Is %d prime ? ",num) + IntStream.range(2,num).noneMatch(i->num%i==0));
        System.out.println(String.format("Factors of %d is:: ",num));
        IntStream.range(2,num).filter(i->num%i==0).filter(z->z%num!=0).mapToObj(z->z+" ").forEach(System.out::print);

    }
}
