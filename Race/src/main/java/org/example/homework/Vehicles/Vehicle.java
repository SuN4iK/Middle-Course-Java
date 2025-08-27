package org.example.homework.Vehicles;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.example.homework.OtherInterfaces.Penalizable;

@Getter
@ToString
@SuperBuilder
public abstract class Vehicle implements Penalizable {
    protected final String licensePlate;
    protected final String color;
    protected final int power;
    protected double fuel;
    protected double penaltyHours;

    protected Vehicle(String licensePlate, String color, int power, double fuel) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.power = power;
        this.fuel = fuel;
        this.penaltyHours = 0;
    }

    @Override
    public double getPenaltyHours() {
        return penaltyHours;
    }

    @Override
    public void applyPenalization(double penaltyHours) {
        this.penaltyHours += penaltyHours;
    }

    public abstract void consumeFuel(double amount);
}