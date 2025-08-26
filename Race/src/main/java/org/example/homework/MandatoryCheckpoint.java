package org.example.homework;

import lombok.Builder;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
public class MandatoryCheckpoint extends Checkpoint {

    @Builder
    public MandatoryCheckpoint(String name, double latitude, double longitude) {
        super(name, latitude, longitude);
    }
}
