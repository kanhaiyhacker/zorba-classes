package org.example.jdbc;

import org.example.utility.DatabaseUtility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablesAndSchema {
    public static void main(String[] args) {
        Connection con;
        con = DatabaseUtility.getConnection();
        if (con == null) return;
        try {
            createDatabase(con);
            createTables(con);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void createDatabase(Connection connection) throws SQLException {
        String query = "create database if not exists practice_jdbc";
        String useDatabase = "use practice_jdbc";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.executeUpdate(useDatabase);
        statement.close();
    }

    public static void createTables(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        // create tourist table
        String createTouristTableQuery = "create table if not exists tourist(tourist_id int, tourist_name varchar(100), address varchar(100), mobile int)";
        statement.execute(createTouristTableQuery);

        // create vehicle table
        String createVehicleTableQuery = "create table if not exists vehicle(vehicle_id int, vehicle_type varchar(55), vehicle_reg varchar(100))";
        statement.execute(createVehicleTableQuery);

        // create tourist_spot table
        String createTouristSpotTableQuery = "create table if not exists tourist_spot(tourist_spot_id int, tourist_spot_name varchar(255))";
        statement.execute(createTouristSpotTableQuery);

        //  declare tourist_id as pK in tourist table.
        String touristPKQuery = "alter table tourist add constraint pk_tourist primary key(tourist_id)";
        statement.execute(touristPKQuery);

        //  declare vehicle_id as pK in vehicle table.
        String vehiclePKQuery = "alter table vehicle add constraint pk_vehicle primary key (vehicle_id)";
        statement.execute(vehiclePKQuery);

        //. declare tourist_spot_id as pK for tourist_spot table.
        String touristSpotPkQuery = "alter table tourist_spot add constraint pk_tourist primary key (tourist_spot_id)";
        statement.execute(touristSpotPkQuery);

        //  create a new column named vehicle_id in tourist table, declare it as FK referencing
        //   to vehicle_id in vehicle table.
        String touristNewColumnQuery = "alter table tourist add column vehicle_id int";
        statement.execute(touristNewColumnQuery);

        String touristFKQuery = "alter table tourist add constraint fk_vehicle foreign key(vehicle_id) references vehicle(vehicle_id)";
        statement.execute(touristFKQuery);


        // create a new column tourist_spot_id in vehicle table, declare it as FK referencing to
        //    tourist_spot_id of tourist_spot tables.
        String vehicleNewColumnQuery = "alter table vehicle add column tourist_spot_id int";
        statement.execute(vehicleNewColumnQuery);

        String vehicleFKQuery = "alter table vehicle add constraint vehicle_fk foreign key(tourist_spot_id) references tourist_spot(tourist_spot_id)";
        statement.execute(vehicleFKQuery);

    }
}
