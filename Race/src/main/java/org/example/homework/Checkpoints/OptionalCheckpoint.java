package org.example.homework.Checkpoints;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class OptionalCheckpoint extends Checkpoint {
    private final double penaltyHours;

    public OptionalCheckpoint(String name, double latitude, double longitude, double penaltyHours) {
        super(name, latitude, longitude);
        validatePenalty(penaltyHours);
        this.penaltyHours = penaltyHours;
    }

    private void validatePenalty(double penaltyHours) {
        if (penaltyHours < 0) {
            throw new IllegalArgumentException("Штраф должен быть больше нуля");
        }
    }
}