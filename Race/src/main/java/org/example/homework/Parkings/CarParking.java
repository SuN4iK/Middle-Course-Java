package org.example.homework.Parkings;

import org.example.homework.Vehicles.Vehicle;

public class CarParking implements Parkable {
    @Override
    public void park(Vehicle vehicle) {
        System.out.println("Легковая машина " + vehicle.getLicensePlate() + " припаркована");
    }
}
