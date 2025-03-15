package org.example.jdbc;

import org.example.model.Tourist;
import org.example.model.TouristSpot;
import org.example.model.vechicle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

// Data Generator class the get the user data from the user.
public class DataGenerator {

    public static void checkNextLine(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    // get input form the user and return Vehicle
    public static vechicle getVehicleData(Scanner scanner, List<TouristSpot> touristSpots) {
        checkNextLine(scanner);
        System.out.println("Enter the type of the vehicle: ");
        String type = scanner.nextLine();
        System.out.println("Enter the registration number of the vehicle: ");
        String vehicleReg = scanner.next();
        showAllTouristSpot(touristSpots);
        System.out.println("Enter the tourist spot of the vehicle: ");
        checkNextLine(scanner);
        String tourist = scanner.nextLine();
        while (checkTouristSpot(tourist, touristSpots) == null) {
            System.out.println("Please enter a valid tourist spot: ");
            showAllTouristSpot(touristSpots);
            System.out.println("Enter the tourist spot of the vehicle: ");
            tourist = scanner.nextLine();
            checkNextLine(scanner);
        }

        final TouristSpot touristSpot = checkTouristSpot(tourist, touristSpots);
        assert touristSpot != null;
        return new vechicle(0, type, vehicleReg, touristSpot.getTouristSpotId());
    }

    // get tourist data
    public static Tourist getTouristData(Scanner scanner, List<TouristSpot> touristSpots, Connection connection) throws SQLException {
        System.out.println("Enter the name of the tourist: ");
        checkNextLine(scanner);
        String name = scanner.nextLine();
        System.out.println("Enter the mobile number of the tourist  : ");
        int mobile = scanner.nextInt();
        checkNextLine(scanner);
        showAllTouristSpot(touristSpots);
        System.out.println("Enter the tourist spot from the above options:  ");
        String tourist = scanner.nextLine();
        List<vechicle> vehicles = getAllVehicleWithTouristSpot(tourist, connection);
        showAllVehicleType(vehicles);
        System.out.println("Choose the type of the vehicle from the above options: ");
        String vehicleType = scanner.nextLine();
        // check if the entered value is present in database
        while (checkVehicleType(vehicleType, vehicles) == null) {
            System.out.println("Entered vehicle type is not available. Please try again.");
            showAllVehicleType(vehicles);
            System.out.println("Enter the vehicle type of the tourist: ");
            vehicleType = scanner.nextLine();
            checkNextLine(scanner);
        }
        final vechicle vechicle = checkVehicleType(vehicleType, vehicles);

        System.out.println("Enter the address of the tourist: ");
        String address = scanner.nextLine();

        assert vechicle != null;
        return new Tourist(0, name, mobile, address, vechicle.getVehicleId());
    }

    public static List<vechicle> getAllVehicleWithTouristSpot(String touristSpot, Connection connection) throws SQLException {
        List<vechicle> vehicles = new ArrayList<>();
        String query = "select * from vehicle where tourist_spot_id in (select tourist_spot_id from tourist_spot where tourist_spot_name = '" + touristSpot + "')";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            vehicles.add(new vechicle(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)));
        }
        return vehicles;
    }

    // get tourist spot data form the user
    public static TouristSpot getTouristSpotData(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the name of the tourist Spot: ");
        String name = scanner.nextLine();


        return new TouristSpot(0, name);
    }

    // show all the tourist spot data
    public static void showAllTouristSpot(List<TouristSpot> touristSpots) {
        System.out.println("**************************************");
        System.out.println("Available tourist spots: ");
        for (int i = 0; i < touristSpots.size(); i++) {
            System.out.println((i + 1) + ". " + touristSpots.get(i).getTouristSpotName());
        }
        System.out.println("**************************************");
    }

    // show all the vehicle type data
    public static void showAllVehicleType(List<vechicle> vehicles) {
        System.out.println("**************************************");
        System.out.println("Available vehicles: ");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i).getVehicleType());
        }
        System.out.println("**************************************");
    }

    // check if the user enter tourist spot available in database
    public static TouristSpot checkTouristSpot(String touristSpot, List<TouristSpot> touristSpots) {
        for (TouristSpot spot : touristSpots) {
            if (touristSpot.equalsIgnoreCase(spot.getTouristSpotName())) {
                return spot;
            }
        }
        return null;
    }

    // check if the user enter vehicle type available in database
    public static vechicle checkVehicleType(String vehicleType, List<vechicle> vehicles) {
        for (vechicle vehicle : vehicles) {
            if (vehicleType.equalsIgnoreCase(vehicle.getVehicleType())) {
                return vehicle;
            }
        }
        return null;
    }
}
