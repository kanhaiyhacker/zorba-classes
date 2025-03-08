package org.example.model;

public class TouristSpot {
    private final int touristSpotId;
    private final String touristSpotName;

    public TouristSpot(int touristSpotId, String touristSpotName) {
        this.touristSpotId = touristSpotId;
        this.touristSpotName = touristSpotName;
    }

    public int getTouristSpotId() {
        return touristSpotId;

    }

    public String getTouristSpotName() {
        return touristSpotName;
    }

    @Override
    public String toString() {
        return "TouristSpot{" +
                "touristSpotId=" + touristSpotId +
                ", touristSpotName='" + touristSpotName + '\'' +
                '}';
    }
}
