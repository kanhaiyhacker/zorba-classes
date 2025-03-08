package org.example.jdbc;

import org.example.utility.DatabaseUtility;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTableJDBC {

    public static void main(String[] args) {
        Connection con = DatabaseUtility.getConnection();
        if (con == null) return;
        String tableQuery = "create table if not exists employee(id int primary key auto_increment, name varchar(100), address varchar(100), email varchar(100), salary double)";
        try {
            Statement statement = con.createStatement();
            statement.execute(tableQuery);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
