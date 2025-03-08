package org.example.utility;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtility {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Properties properties = new Properties();
            File file = new File("src/main/resources/database.properties");
            properties.load(new FileInputStream(file));
            final String username = properties.getProperty("username");
            final String password = properties.getProperty("password");
            final String database = properties.getProperty("database");


            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, username, password);
            System.out.println("Connected to the database successfully");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return con;
    }
}
