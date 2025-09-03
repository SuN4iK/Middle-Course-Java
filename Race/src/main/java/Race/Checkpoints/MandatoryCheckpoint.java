package Race.Checkpoints;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class MandatoryCheckpoint extends Checkpoint {
    public MandatoryCheckpoint(String name, double latitude, double longitude) {
        super(name, latitude, longitude);
    }
}