package org.example.homework;

import org.example.homework.Checkpoints.Checkpoint;
import org.example.homework.Checkpoints.MandatoryCheckpoint;
import org.example.homework.Checkpoints.OptionalCheckpoint;
import org.example.homework.Factories.CarFactory;
import org.example.homework.Factories.TruckFactory;
import org.example.homework.Factories.VehicleFactory;
import org.example.homework.Vehicles.Vehicle;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        var carFactory = new CarFactory();
        var truckFactory = new TruckFactory();

        var car = carFactory.createVehicle("А123ВС77", "Красный", 150, 60.0);
        var truck = truckFactory.createVehicle("М456КН77", "Синий", 300, 120.0);

        var checkpoints = new Checkpoint[]{
                MandatoryCheckpoint.builder().name("Старт").latitude(55.7558).longitude(37.6173).build(),
                OptionalCheckpoint.builder().name("Горный перевал").latitude(43.5853).longitude(39.7203).penaltyHours(2.5).build(),
                MandatoryCheckpoint.builder().name("Финиш").latitude(59.9343).longitude(30.3351).build()
        };

        simulateRace(car, checkpoints, carFactory);
        simulateRace(truck, checkpoints, truckFactory);

        System.out.println("Результаты гонки:");
        System.out.println("Легковая машина: " + car);
        System.out.println("Грузовик: " + truck);
    }

    private static void simulateRace(Vehicle vehicle, Checkpoint[] checkpoints, VehicleFactory factory) {
        var parking = factory.createParking();
        var serviceStation = factory.createServiceStation();

        for (var checkpoint : checkpoints) {
            System.out.println("КП " + checkpoint.getName() + " для " + vehicle.getLicensePlate());

            var passed = random.nextBoolean();
            if (passed) {
                System.out.println("Прошел КП");
                parking.park(vehicle);
                serviceStation.repair(vehicle);
                vehicle.consumeFuel(5.0);
            } else {
                System.out.println("Не прошел КП");
                if (checkpoint instanceof OptionalCheckpoint optionalCheckpoint) {
                    vehicle.applyPenalization(optionalCheckpoint.getPenaltyHours());
                }
            }
        }
    }
}