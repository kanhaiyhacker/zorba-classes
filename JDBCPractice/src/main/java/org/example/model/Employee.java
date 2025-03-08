package org.example.model;

public class Employee {
    private final int empId;
    private final String name;
    private final String address;
    private final String email;
    private final double salary;

    public Employee(int empId, String name, String address, String email, double salary) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
}
