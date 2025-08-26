package org.example.homework;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Car implements Penalizable {
    private final double power;
    private final String color;
    private final double fuelCapacity;
    private double totalPenaltyHours;

    @Builder
    public Car(double power, String color, double fuelCapacity) {
        validateParameters(color, power, fuelCapacity);

        this.color = color;
        this.power = power;
        this.fuelCapacity = fuelCapacity;
        this.totalPenaltyHours = 0.0;
    }
    private void validateParameters(String color, double power,
                                    double fuelCapacity) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет не может быть пустым");
        }
        if (power <= 0) {
            throw new IllegalArgumentException("Мощность должна быть положительной");
        }
        if (fuelCapacity <= 0) {
            throw new IllegalArgumentException("Вместимость бака должна быть положительной");
        }
    }

    @Override
    public double getPenaltyHours() {
        return totalPenaltyHours;
    }

    @Override
    public void applyPenalization(double penaltyHours) {
        this.totalPenaltyHours += penaltyHours;
    }
}
