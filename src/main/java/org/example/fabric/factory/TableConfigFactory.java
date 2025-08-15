package org.example.fabric.factory;

import org.example.fabric.enums.Models;

public class TableConfigFactory {
    public static TableConfig getTableConfig(Models model) {
        switch (model) {
            case START -> {
                return getStartConfig();

            }
            case MEDIUM -> {
                return getMediumConfig();
            }
            case FULL -> {
                return getFullConfig();
            }
        }
        return null;
    }

    public static TableConfig getStartConfig() {
        return TableConfig.builder()
                .model(Models.FULL)
                .underframeMinHeight(20)
                .underframeMaxHeight(50)
                .electricMotorLifeTimeYears(2)
                .electricMotorCarryingCapacityKg(15)
                .electricMotorSpeedMs(1)
                .quantityUsb(0)
                .hasCableChannel(false)
                .build();
    }
    public static TableConfig getMediumConfig() {
        return TableConfig.builder()
                .model(Models.FULL)
                .underframeMinHeight(35)
                .underframeMaxHeight(75)
                .electricMotorLifeTimeYears(5)
                .electricMotorCarryingCapacityKg(50)
                .electricMotorSpeedMs(2)
                .quantityUsb(2)
                .hasCableChannel(true)
                .build();
    }
    public static TableConfig getFullConfig() {
        return TableConfig.builder()
                .model(Models.FULL)
                .underframeMinHeight(50)
                .underframeMaxHeight(100)
                .electricMotorLifeTimeYears(10)
                .electricMotorCarryingCapacityKg(70)
                .electricMotorSpeedMs(3)
                .quantityUsb(6)
                .hasCableChannel(true)
                .build();


    }
}
