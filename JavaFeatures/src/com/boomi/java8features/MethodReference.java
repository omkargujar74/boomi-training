package com.boomi.java8features;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface InterfaceEmployee {
    Employee getEmployeeObj();
}

class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}

public class MethodReference {
    public static void main(String[] args) {
        List<Employee> employees = getEmployee();
        MethodReference methodReference = new MethodReference();

        //employees.forEach(emp -> System.out.println("ID "+emp.getId()+" Name "+emp.getName()+" Salary "+emp.getSalary()));
        employees.forEach(methodReference::printEmployee);

        InterfaceEmployee emp = Employee::new;
    }

    public static List<Employee> getEmployee() {
        return IntStream.range(1, 11)
                .mapToObj(id -> new Employee(id, "Employee" + id, new Random().nextInt(50000)))
                .collect(Collectors.toList());
    }

    public void printEmployee(Employee emp) {
        System.out.println("ID " + emp.getId() + " Name " + emp.getName() + " Salary " + emp.getSalary());
    }
}
