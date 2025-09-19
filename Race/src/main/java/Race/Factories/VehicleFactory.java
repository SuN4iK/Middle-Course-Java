package Race.Factories;

import Race.Parkings.Parkable;
import Race.Services.Service;
import Race.Vehicles.Vehicle;

public interface VehicleFactory {
    Vehicle createVehicle(String licensePlate, String color, int power, double fuel);
    Parkable createParking();
    Service createServiceStation();
}
