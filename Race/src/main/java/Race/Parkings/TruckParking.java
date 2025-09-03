package Race.Parkings;

import Race.Vehicles.Vehicle;

public class TruckParking implements Parkable {
    @Override
    public void park(Vehicle vehicle) {
        System.out.println("Грузовик " + vehicle.getLicensePlate() + " припаркован");
    }
}
