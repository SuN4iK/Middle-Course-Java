package Race.Parkings;

import Race.Vehicles.Vehicle;

public class CarParking implements Parkable {
    @Override
    public void park(Vehicle vehicle) {
        System.out.println("Легковая машина " + vehicle.getLicensePlate() + " припаркована");
    }
}
