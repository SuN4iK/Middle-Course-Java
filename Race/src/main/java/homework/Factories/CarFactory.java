package homework.Factories;

import homework.Vehicles.Vehicle;
import homework.Vehicles.Car;
import homework.Parkings.CarParking;
import homework.Services.CarService;
import homework.Parkings.Parkable;
import homework.Services.Service;

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

