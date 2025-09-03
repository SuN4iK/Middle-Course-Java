package Race.Checkpoints;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public abstract class Checkpoint {
    private final String name;
    private final double latitude;
    private final double longitude;

    protected Checkpoint(String name, double latitude, double longitude) {
        validateCoordinates(latitude, longitude);
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
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