package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Integer vehicleId;


    @Column(name = "is_rented")
    private Boolean isRented;

    @Column(name = "manufacture_year")
    private Integer manufactureYear;

    @Column(name = "renter_name")
    private String renterName;


}
