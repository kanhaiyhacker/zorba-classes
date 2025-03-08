package org.example.jdbc;

import java.util.Scanner;

public class PracticeClassExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of spot: ");
        int numberOfSpots = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of the tourist: ");
        String name = scanner.nextLine();

        System.out.println("Enter the address of the tourist: ");
        String address = scanner.nextLine();
        System.out.println("Enter the vehicle type of the tourist: ");
        String vehicleType = scanner.nextLine();
        int someValue = scanner.nextInt();
        System.out.println(someValue);
        System.out.println(name);
        System.out.println(address);
        System.out.println(vehicleType);
        System.out.println(numberOfSpots);
    }
}
