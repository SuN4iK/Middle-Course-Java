package org.example.homework;

import lombok.Builder;
import lombok.ToString;
@ToString(callSuper = true)
public class OptionalCheckpoint extends Checkpoint implements Penalizable{
    private final double penaltyHours;
    private double totalPenaltyApplied;

    @Builder
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
    @Override
    public void applyPenalization(double penaltyHours) {
        this.totalPenaltyApplied += penaltyHours;
    }

    @Override
    public double getPenaltyHours() {
        return totalPenaltyApplied;
    }
}