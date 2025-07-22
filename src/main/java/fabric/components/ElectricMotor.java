package fabric.components;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ElectricMotor {
    int speedMs;
    int lifeTimeYears;
    int carryingCapacityKg;
}
