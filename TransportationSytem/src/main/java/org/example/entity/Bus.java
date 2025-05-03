package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Setter
@Getter

@Entity
@Table(name = "bus")
public class Bus extends Vehicle {
    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "is_sleeper")
    private Boolean isSleeper;

    @Column(name = "is_ac")
    private Boolean isAC;


}
