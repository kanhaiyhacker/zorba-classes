package org.example.xml_hibernate.model;

public class Employee {
    private int empId;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.empId = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int id) {
        this.empId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
