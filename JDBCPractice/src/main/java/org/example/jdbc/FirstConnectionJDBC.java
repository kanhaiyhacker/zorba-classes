package org.example.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class FirstConnectionJDBC {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            File file = new File("src/main/resources/keys.properties");
            properties.load(new FileInputStream(file));
            final String username = properties.getProperty("username");
            final String password = properties.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", username, password);
            System.out.println("Connected to the database successfully");

            // create a schema
            String query = " CREATE DATABASE IF NOT EXISTS hibernate_test";
            String query2 = " USE hibernate_test";
            String query3= "create table  NOT EXISTS student(id int primary key auto_increment, name varchar(50), age int)";

            Statement statement = con.createStatement();
            statement.execute(query);
            statement.execute(query2);
            statement.executeQuery(query3);
            statement.close();

            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
