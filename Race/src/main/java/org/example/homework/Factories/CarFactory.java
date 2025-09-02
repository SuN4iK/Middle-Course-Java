package org.example.homework.Factories;

import org.example.homework.Vehicles.Vehicle;
import org.example.homework.Vehicles.Car;
import org.example.homework.Parkings.CarParking;
import org.example.homework.Services.CarService;
import org.example.homework.Parkings.Parkable;
import org.example.homework.Services.Service;

public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String licensePlate, String color, int power, double fuel) {
        return Car.builder()
                .licensePlate(licensePlate)
                .color(color)
                .power(power)
                .fuel(fuel)
                .build();
    }

    @Override
    public Parkable createParking() {
        return new CarParking();
    }

    @Override
    public Service createServiceStation() {
        return new CarService();
    }
}

