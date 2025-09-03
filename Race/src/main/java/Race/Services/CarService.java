package Race.Services;

import Race.Vehicles.Vehicle;

public class CarService implements Service {
    @Override
    public void repair(Vehicle vehicle) {
        System.out.println("Легковая машина " + vehicle.getLicensePlate() + " отремонтирована");
    }
}
