package org.example.model;

public class Destination {
    private int destinationId;
    private String name;
    private String location;
    private Address address;

    public Destination(Address address) {
        this.address = address;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Destination{" +
                "destinationId=" + destinationId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", address=" + address +
                '}';
    }
}
