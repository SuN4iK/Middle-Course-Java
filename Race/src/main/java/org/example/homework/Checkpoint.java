package org.example.homework;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder

public abstract class Checkpoint {
    private final String name;
    private final double latitude;
    private final double longitude;

    protected void validate() {
        validateCoordinates(latitude, longitude);
    }
    private void validateCoordinates(double latitude, double longitude) {
        if (latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("Широта должна быть в диапазоне -90.0° до +90.0°");
        }
        if (longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("Долгота должна быть в диапазоне -180.0° до +180.0°");
        }
    }
}
