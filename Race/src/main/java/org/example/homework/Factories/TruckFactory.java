package org.example.homework.Factories;

import org.example.homework.Vehicles.Vehicle;
import org.example.homework.Parkings.Parkable;
import org.example.homework.Services.Service;
import org.example.homework.Vehicles.Truck;
import org.example.homework.Parkings.TruckParking;
import org.example.homework.Services.TruckService;

public class TruckFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String licensePlate, String color, int power, double fuel) {
        return Truck.builder()
                .licensePlate(licensePlate)
                .color(color)
                .power(power)
                .fuel(fuel)
                .build();
    }

    @Override
    public Parkable createParking() {
        return new TruckParking();
    }

    @Override
    public Service createServiceStation() {
        return new TruckService();
    }
}
