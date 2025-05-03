package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "bike")
public class Bike extends Vehicle {
    @Column()
    private String color;

    @Column(name = "is_auto_gear")
    private boolean isAutoGear;


}
