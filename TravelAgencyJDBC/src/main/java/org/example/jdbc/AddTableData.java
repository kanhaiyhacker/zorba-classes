package org.example.jdbc;

import org.example.model.Tourist;
import org.example.model.TouristSpot;
import org.example.model.Vechicle;
import org.example.utility.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTableData {
    public static void main(String[] args) {
        Connection con = DatabaseUtility.getConnection();
        if (con == null) {
            return;
        }
        try {
            Scanner scanner = new Scanner(System.in);
            addTouristSpotData(con, scanner);
            System.out.println("*****************************\n");
            addVehicleData(con, scanner);
            System.out.println("****************************\n");
            addTouristData(con, scanner);
            scanner.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // method to add the vehicle data in database
    public static void addVehicleData(Connection connection, Scanner scanner) throws SQLException {
        List<TouristSpot> touristSpots = getAllTouristSpots(connection);
        if (touristSpots.isEmpty()) {
            System.out.println("No tourist spots found");
            return;
        }
        System.out.println("Enter number of vehicles to be added: ");
        int numberOfVehicles = scanner.nextInt();
        List<Vechicle> vehicles = new ArrayList<>();
        for (int i = 0; i < numberOfVehicles; i++) {
            vehicles.add(DataGenerator.getVehicleData(scanner, touristSpots));
        }

        String insertQuery = "insert into vehicle values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        for (Vechicle vehicle : vehicles) {
            preparedStatement.setInt(1, vehicle.getVehicleId());
            preparedStatement.setString(2, vehicle.getVehicleType());
            preparedStatement.setString(3, vehicle.getVehicleReg());
            preparedStatement.setInt(4, vehicle.getTouristSpotId());
            int rowInserted = preparedStatement.executeUpdate();
            System.out.println(rowInserted + " Rows inserted...");
        }
        System.out.println(vehicles);

    }

    // method to add tourist data in database
    public static void addTouristData(Connection connection, Scanner scanner) throws SQLException {
        List<Vechicle> vehicles = getAllVehicles(connection);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found");
            return;
        }
        System.out.println("Enter number of tourist to be added: ");
        int numberOfTourists = scanner.nextInt();
        List<Tourist> tourists = new ArrayList<>();
        for (int i = 0; i < numberOfTourists; i++) {
            tourists.add(DataGenerator.getTouristData(scanner, vehicles));
        }
        String insertQuery = "insert into tourist values(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        for (Tourist tourist : tourists) {
            preparedStatement.setInt(1, tourist.getTouristId());
            preparedStatement.setString(2, tourist.getTouristName());
            preparedStatement.setString(3, tourist.getAddress());
            preparedStatement.setInt(4, tourist.getMobile());
            preparedStatement.setInt(5, tourist.getVehicleId());
            int rowInserted = preparedStatement.executeUpdate();
            System.out.println(rowInserted + " Rows inserted...");
        }
        System.out.println(tourists);

    }

    // method to add tourist spot in database
    public static void addTouristSpotData(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter number of tourist spot to be added: ");
        int numberOfTouristSpots = scanner.nextInt();
        List<TouristSpot> touristSpots = new ArrayList<>();
        for (int i = 0; i < numberOfTouristSpots; i++) {
            touristSpots.add(DataGenerator.getTouristSpotData(scanner));
        }
        String insertQuery = "insert into tourist_spot values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        for (TouristSpot touristSpot : touristSpots) {
            preparedStatement.setInt(1, touristSpot.getTouristSpotId());
            preparedStatement.setString(2, touristSpot.getTouristSpotName());
            int rowInserted = preparedStatement.executeUpdate();
            System.out.println(rowInserted + " Rows inserted...");
        }

        System.out.println(touristSpots);

    }

    // get all the tourist spot data from the database
    public static List<TouristSpot> getAllTouristSpots(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from tourist_spot");
        List<TouristSpot> spots = new ArrayList<>();
        while (resultSet.next()) {
            spots.add(new TouristSpot(resultSet.getInt(1), resultSet.getString(2)));
        }
        statement.close();
        return spots;
    }

    // get all the vehicle type data from the database
    public static List<Vechicle> getAllVehicles(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from vehicle");
        List<Vechicle> spots = new ArrayList<>();
        while (resultSet.next()) {
            spots.add(new Vechicle(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)));
        }
        statement.close();
        return spots;
    }
}
