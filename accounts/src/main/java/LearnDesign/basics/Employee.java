package LearnDesign.basics;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
    }


    public static int reverseOrder(Employee o1, Employee o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o2.getName(), o1.getName());
    }

    private String name;
    private int age;
    private double salary;
    private Department department;

    public Employee(String name, int age, double salary,Department department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary + ", Department: "+department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
