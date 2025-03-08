package org.example.jdbc;

import org.example.model.Tourist;
import org.example.model.TouristSpot;
import org.example.model.Vechicle;

import java.util.Scanner;
import java.util.List;

public class DataGenerator {
    // get input form the user and return Vehicle
    public static Vechicle getVehicleData(Scanner scanner, List<TouristSpot> touristSpots) {
        System.out.println("Enter the id of the vehicle: ");
        int id = scanner.nextInt();
        System.out.println("Enter the type of the vehicle: ");
        scanner.nextLine();
        String type = scanner.next();
        System.out.println("Enter the registration number of the vehicle: ");
        scanner.nextLine();
        String vehicleReg = scanner.next();
        showAllTouristSpot(touristSpots);
        System.out.println("Enter the tourist spot of the vehicle: ");
        scanner.nextLine();
        String tourist = scanner.nextLine();
        while (checkTouristSpot(tourist, touristSpots) == null) {
            System.out.println("Please enter a valid tourist spot: ");
            showAllTouristSpot(touristSpots);
            System.out.println("Enter the tourist spot of the vehicle: ");
            tourist = scanner.nextLine();
            scanner.nextLine();
        }

        final TouristSpot touristSpot = checkTouristSpot(tourist, touristSpots);
        assert touristSpot != null;
        return new Vechicle(id, type, vehicleReg, touristSpot.getTouristSpotId());
    }

    // get tourist data
    public static Tourist getTouristData(Scanner scanner, List<Vechicle> vechicles) {
        System.out.println("Enter the id of the tourist: ");
        int id = scanner.nextInt();
        System.out.println("Enter the name of the tourist: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter the mobile number of the tourist  : ");
        int mobile = scanner.nextInt();
        scanner.nextLine();
        showAllVehicleType(vechicles);
        System.out.println("Enter the vehicle type of the tourist: ");
        String vehicleType = scanner.nextLine();

        // check if the entered value is present in database
        while (checkVehicleType(vehicleType, vechicles) == null) {
            System.out.println("Entered vehicle type is not available. Please try again.");
            showAllVehicleType(vechicles);
            System.out.println("Enter the vehicle type of the tourist: ");
            vehicleType = scanner.nextLine();
        }
        final Vechicle vechicle = checkVehicleType(vehicleType, vechicles);

        System.out.println("Enter the address of the tourist: ");
        String address = scanner.nextLine();

        assert vechicle != null;
        return new Tourist(id, name, mobile, address, vechicle.getVehicleId());
    }

    // get tourist spot data form the user
    public static TouristSpot getTouristSpotData(Scanner scanner) {
        System.out.println("Enter the id of the Tourist Spot: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of the tourist Spot: ");
        String name = scanner.nextLine();


        return new TouristSpot(id, name);
    }

    public static void showAllTouristSpot(List<TouristSpot> touristSpots) {
        System.out.println("**************************************");
        System.out.println("Available tourist spots: ");
        for (int i = 0; i < touristSpots.size(); i++) {
            System.out.println((i + i) + ". " + touristSpots.get(i).getTouristSpotName());
        }
        System.out.println("**************************************");
    }

    public static void showAllVehicleType(List<Vechicle> vehicles) {
        System.out.println("**************************************");
        System.out.println("Available vehicles: ");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i).getVehicleType());
        }
        System.out.println("**************************************");
    }

    public static TouristSpot checkTouristSpot(String touristSpot, List<TouristSpot> touristSpots) {
        for (TouristSpot spot : touristSpots) {
            if (touristSpot.equalsIgnoreCase(spot.getTouristSpotName())) {
                return spot;
            }
        }
        return null;
    }

    public static Vechicle checkVehicleType(String vehicleType, List<Vechicle> vehicles) {
        for (Vechicle vehicle : vehicles) {
            if (vehicleType.equalsIgnoreCase(vehicle.getVehicleType())) {
                return vehicle;
            }
        }
        return null;
    }
}
