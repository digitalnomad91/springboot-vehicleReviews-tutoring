package io.catalyte.services;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;
import io.catalyte.exceptions.ResourceNotFound;
import io.catalyte.exceptions.ServiceUnavailable;
import io.catalyte.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> GetVehicles() { /* String type, String make, String model, int year */
        List<Vehicle> retVehicles = new ArrayList<>();
        try {
            retVehicles = vehicleRepository.findAll();
            return retVehicles;
        } catch (DataAccessException dae) {
            throw new ServiceUnavailable(dae.getMessage());
        }
    }

    @Override
    public Vehicle GetVehicleById(Long id) {
        Vehicle getVehicle = null;
        try {
            getVehicle = vehicleRepository.findById(id).orElse(null);
            return getVehicle;
        } catch (DataAccessException dae) {
            throw new ServiceUnavailable(dae.getMessage());
        }
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle;

    }

    @Override
    public Vehicle updateVehicle(Vehicle newVehicle) {

        vehicleRepository.save(newVehicle);
        return newVehicle;
    }


    @Override
    public void removeVehicle(Long id) {
        try {
            Vehicle vehicleToRemove = vehicleRepository.findById(id).orElse(null);
            vehicleRepository.delete(vehicleToRemove);
        } catch (DataAccessException dae) {
            throw new ServiceUnavailable(dae.getMessage());
        }

    }

    @Override
    public Vehicle GetByMakeAndModel(String make, String model){

        Vehicle retVehicle= null;
        try{
            retVehicle =  vehicleRepository.findByMakeAndModel(make, model);
        }
        catch (DataAccessException dae) {

            throw new ServiceUnavailable(dae.getMessage());
        }

        if (retVehicle == null){
            throw new ResourceNotFound("Could not find a game with that title.");
        }
        return retVehicle;
    }


    }
