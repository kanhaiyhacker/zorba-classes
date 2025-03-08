package org.example.model;

public class Vechicle {
    private final int vehicleId;
    private final String VehicleType;
    private final String VehicleReg;
    private final int touristSpotId;

    public Vechicle(int vehicleId, String vehicleType, String vehicleReg, int touristSpotId) {
        this.vehicleId = vehicleId;
        this.VehicleType = vehicleType;
        this.VehicleReg = vehicleReg;
        this.touristSpotId = touristSpotId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public String getVehicleReg() {
        return VehicleReg;
    }

    public int getTouristSpotId() {
        return touristSpotId;
    }


    @Override
    public String toString() {
        return "Vechicle{" +
                "vehicleId=" + vehicleId +
                ", VehicleType='" + VehicleType + '\'' +
                ", VehicleReg='" + VehicleReg + '\'' +
                ", touristSpotId=" + touristSpotId +
                '}';
    }
}
