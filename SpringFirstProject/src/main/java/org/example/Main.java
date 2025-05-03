package org.example;

import org.example.model.Address;
import org.example.model.Destination;
import org.example.model.Driver;
import org.example.model.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//
//Write a Spring core application for the below requirements,
//
//Vehicle(vehicleId, vehicleName, vehicleType)
//Driver(driverId, driverName)
//Destination(destinationId, name, location)
//Address(addressId, area, pincode, country)
//
//1. Driver has a vehicle (Autowire by name)
//2. Destination has an address(constructor DI)
//3. driver has destination (setter DI)
//4. Driver has an address (autowire by constructor)
//
//You need to create and mapped the each class accordingly
//in main class create object and pass  parameter and show the flow of data.
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        Driver driver = applicationContext.getBean(Driver.class);
        Address address = applicationContext.getBean(Address.class);

        address.setArea("new area");
        address.setCountry("china");

        driver.setAddress(address);
        System.out.println(driver);

    }
}