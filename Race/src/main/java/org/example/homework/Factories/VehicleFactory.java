package org.example.homework.Factories;

import org.example.homework.Parkings.Parkable;
import org.example.homework.Services.Service;
import org.example.homework.Vehicles.Vehicle;

public interface VehicleFactory {
    Vehicle createVehicle(String licensePlate, String color, int power, double fuel);
    Parkable createParking();
    Service createServiceStation();
}
