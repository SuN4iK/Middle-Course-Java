package Race.Factories;

import Race.Vehicles.Vehicle;
import Race.Vehicles.Car;
import Race.Parkings.CarParking;
import Race.Services.CarService;
import Race.Parkings.Parkable;
import Race.Services.Service;

public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle(String licensePlate, String color, int power, double fuel) {
        return Car.builder()
                .licensePlate(licensePlate)
                .color(color)
                .power(power)
                .fuel(fuel)
                .build();
    }

    @Override
    public Parkable createParking() {
        return new CarParking();
    }

    @Override
    public Service createServiceStation() {
        return new CarService();
    }
}

