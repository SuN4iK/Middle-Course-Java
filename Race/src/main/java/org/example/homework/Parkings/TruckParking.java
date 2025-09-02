package org.example.homework.Parkings;

import org.example.homework.Vehicles.Vehicle;

public class TruckParking implements Parkable {
    @Override
    public void park(Vehicle vehicle) {
        System.out.println("Грузовик " + vehicle.getLicensePlate() + " припаркован");
    }
}
