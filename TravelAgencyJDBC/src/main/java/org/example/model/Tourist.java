package org.example.model;

public class Tourist {
    final private int touristId;
    final private String touristName;
    final private String address;

    final private int mobile;
    final private int VehicleId;

    public Tourist(int touristId, String touristName, int mobile, String address, int VehicleId) {
        this.touristId = touristId;
        this.touristName = touristName;
        this.mobile = mobile;
        this.VehicleId = VehicleId;
        this.address = address;
    }

    public int getTouristId() {
        return touristId;
    }

    public String getTouristName() {
        return touristName;

    }

    public int getMobile() {
        return mobile;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "touristId=" + touristId +
                ", touristName='" + touristName + '\'' +
                ", address='" + address + '\'' +
                ", mobile=" + mobile +
                ", VehicleId=" + VehicleId +
                '}';
    }
}
