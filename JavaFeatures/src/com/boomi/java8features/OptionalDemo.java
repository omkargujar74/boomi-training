package com.boomi.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class OptionalDemo {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Omkar", 23);

        //Optional<String> name = Optional.of(customer.name);
        Optional<String> name = Optional.ofNullable(customer.getName());
        if (name.isPresent()) {
            System.out.println(name);
        } else {
            System.out.println("There is no name entered");
        }

        System.out.println(name.orElse("There is no name entered"));

        //System.out.println(name.orElseThrow(() -> new IllegalArgumentException("Name is not present")));
        System.out.println(name.map(String::toUpperCase).orElse("NULL"));

        Customer searchedByName = findCustomerByName("Sumit");
        System.out.println("Name = " + searchedByName.getName() + " Age = " + searchedByName.getAge());

    }

    public static List<Customer> getAllCustomers() {
        List<Customer> customers = Arrays.asList(new Customer("Omkar", 23),
                new Customer("Ajit", 24),
                new Customer("Tushar", 25));
        return customers;
    }

    public static Customer findCustomerByName(String name) throws Exception {
        List<Customer> allCustomers = getAllCustomers();
        return allCustomers.stream()
                .filter(customer -> {
                    Optional<String> optionalName = Optional.ofNullable(customer.getName());
                    return (optionalName.orElse("NULL")).equals(name);
                })
                .findAny()
                .orElseThrow(() -> new Exception("Customer with this name not present"));
    }
}
