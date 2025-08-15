package org.example.fabric.components;

import org.example.fabric.enums.Models;
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
