package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "car")
public class Car extends Vehicle {
    @Column
    private String color;

    @Column
    private Integer capacity;

    @Column
    private boolean rentWithDriver;

    @Column
    private String make;

    @Column
    private String model;

    @Column(name = "is_manual")
    private boolean isManual;

    @JoinColumn(name = "car_type")
    @ManyToOne(cascade = CascadeType.ALL, optional = true, targetEntity = CarType.class)
    CarType carType;


}
