package io.catalyte.services;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;

import java.util.List;


public interface VehicleService {
    List<Vehicle> GetVehicles();
    Vehicle GetVehicleById(Long id);
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void removeVehicle(Long id);
    Vehicle GetByMakeAndModel(String make, String model);

}

