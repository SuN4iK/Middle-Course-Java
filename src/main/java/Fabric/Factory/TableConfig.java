package Fabric.Factory;

import Fabric.Enums.Models;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TableConfig {
    Models model;
    int underframeMinHeight;
    int underframeMaxHeight;
    int electricMotorLifeTimeYears;
    int electricMotorSpeedMs;
    int electricMotorCarryingCapacityKg;
    int quantityUsb;
    boolean hasCableChannel;
}

