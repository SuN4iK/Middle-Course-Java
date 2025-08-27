package org.example.homework.Services;

import org.example.homework.Vehicles.Vehicle;

public class TruckService implements Service {
    @Override
    public void repair(Vehicle vehicle) {
        System.out.println("Грузовик " + vehicle.getLicensePlate() + " отремонтирован");
    }
}
