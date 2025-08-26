package org.example.homework;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private static final Map<String, Car> carPrototypes = new HashMap<>();

    // Предварительно зарегистрированные прототипы автомобилей
    static {
        carPrototypes.put("default", Car.builder()
                .color("белый")
                .power(150.0)
                .fuelCapacity(60.0)
                .build());

        carPrototypes.put("sport", Car.builder()
                .color("красный")
                .power(300.0)
                .fuelCapacity(70.0)
                .build());

        carPrototypes.put("economy", Car.builder()
                .color("синий")
                .power(90.0)
                .fuelCapacity(45.0)
                .build());
    }

    // Создание автомобиля по типу (на основе прототипа)
    public static Car createCar(String type) {
        Car prototype = carPrototypes.get(type.toLowerCase());
        if (prototype == null) {
            throw new IllegalArgumentException("Неизвестный тип автомобиля: " + type);
        }

        return Car.builder()
                .color(prototype.getColor())
                .power(prototype.getPower())
                .fuelCapacity(prototype.getFuelCapacity())
                .build();
    }

    // Создание полностью кастомного автомобиля
    public static Car createCustomCar(String color,
                                      double power, double fuelCapacity) {
        return Car.builder()
                .color(color)
                .power(power)
                .fuelCapacity(fuelCapacity)
                .build();
    }

    // Регистрация нового прототипа
    public static void registerPrototype(String type, Car prototype) {
        carPrototypes.put(type.toLowerCase(), prototype);
    }

    // Получение списка доступных типов
    public static String[] getAvailableTypes() {
        return carPrototypes.keySet().toArray(new String[0]);
    }
}
