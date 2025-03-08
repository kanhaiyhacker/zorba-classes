package org.example.jdbc;

import org.example.model.Employee;
import org.example.utility.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PreparedStatementExample {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = DatabaseUtility.getConnection();
        if (con != null) return;
        List<Employee> employeesList = new ArrayList<>();

        for(Employee emp: employeesList){

        }

    }

    private static List<Employee> getEmployeeList() {
        final ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            employees.add(new Employee(100 + i, "Test " + i, "Test Location " + i, "test" + i + 1 + "@gmail.com", 1001 + 100 * new Random().nextInt(10)));
        }
        return employees;
    }
}

