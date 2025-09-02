package Fabric.Components;

import Fabric.Enums.Models;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@Builder
public class Table {
    Models models;
    UnderFrame underFrame;
    Countertop countertop;
    ElectricMotor electricMotor;
    @NonFinal
    int quantityUsb;
    @NonFinal
    boolean hasCabelChannel;
}
