package org.example.model;

public class Driver {
    //Driver(driverId, driverName)
    private String driverId;
    private String driverName;
    private Vehicle vehicle;
    private Destination destination;
    private Address address;

    public Driver(Address address) {
        this.address = address;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Destination getDestination() {
        return destination;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' + "\n" +
                ", vehicle=" + vehicle + "\n" +
                ", destination=" + destination + "\n" +
                ", address=" + address +
                '}';
    }
}
