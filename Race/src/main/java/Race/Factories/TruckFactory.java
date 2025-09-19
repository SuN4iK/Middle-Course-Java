package Race.Factories;

import Race.Vehicles.Vehicle;
import Race.Parkings.Parkable;
import Race.Services.Service;
import Race.Vehicles.Truck;
import Race.Parkings.TruckParking;
import Race.Services.TruckService;

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
