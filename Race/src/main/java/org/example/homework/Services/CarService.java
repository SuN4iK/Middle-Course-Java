package org.example.homework.Services;

import org.example.homework.Vehicles.Vehicle;

public class CarService implements Service {
    @Override
    public void repair(Vehicle vehicle) {
        System.out.println("Легковая машина " + vehicle.getLicensePlate() + " отремонтирована");
    }
}
