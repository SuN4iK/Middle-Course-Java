package homework.Factories;

import homework.Parkings.Parkable;
import homework.Services.Service;
import homework.Vehicles.Vehicle;

public interface VehicleFactory {
    Vehicle createVehicle(String licensePlate, String color, int power, double fuel);
    Parkable createParking();
    Service createServiceStation();
}
