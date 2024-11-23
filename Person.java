/*
 * File: Person.java
 * Class: CSCI1302A
 * Author: David Mbadinga
 * Last modified: Nov 23, 2024
 */ 
import java.text.NumberFormat;
import java.util.Locale;

public class Person implements Comparable<Person> {
    private int age;
    private String name;
    private String address;
    private int zipCode;
    private double salary;

    // Default constructor
    public Person() {
        this.age = 0;
        this.name = "";
        this.address = "";
        this.zipCode = 0;
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Person(int age, String name, String address, int zipCode, double salary) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.salary = salary;
    }

    // Accessors (getters)
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public double getSalary() {
        return salary;
    }

    // Mutators (setters)
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString() method
    @Override
    public String toString() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        return String.format(
                "%d %s %s %d %s",
                age, name, address, zipCode, currencyFormatter.format(salary)
        );
    }

    // Compare by salary in descending order
    @Override
    public int compareTo(Person other) {
        return Double.compare(other.salary, this.salary);
    }
}