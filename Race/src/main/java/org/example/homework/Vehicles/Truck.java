package org.example.homework.Vehicles;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class Truck extends Vehicle {
    public Truck(String licensePlate, String color, int power, double fuel) {
        super(licensePlate, color, power, fuel);
    }

    @Override
    public void consumeFuel(double amount) {
        fuel -= amount * 1.5;
    }
}