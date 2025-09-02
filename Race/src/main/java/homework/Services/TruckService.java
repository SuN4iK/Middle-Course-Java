package homework.Services;

import homework.Vehicles.Vehicle;

public class TruckService implements Service {
    @Override
    public void repair(Vehicle vehicle) {
        System.out.println("Грузовик " + vehicle.getLicensePlate() + " отремонтирован");
    }
}
