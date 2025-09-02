package homework.Factories;

import homework.Vehicles.Vehicle;
import homework.Parkings.Parkable;
import homework.Services.Service;
import homework.Vehicles.Truck;
import homework.Parkings.TruckParking;
import homework.Services.TruckService;

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
