package io.catalyte.controllers;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;
import io.catalyte.services.ReviewService;
import io.catalyte.services.VehicleService;
import javax.swing.border.TitledBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Vehicle> getAllVehicles() { /* @RequestParam(required = false) String type, @RequestParam(required = false) String make, @RequestParam(required = false) String model, @RequestParam(required = false) int year */
        List<Vehicle> retVehicles = vehicleService.GetVehicles();
        return retVehicles;
    }


    @GetMapping(value = "/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.GetVehicleById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @PutMapping
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.removeVehicle(id);
    }

    @GetMapping(value = "reviews")
    public List<Review> getReviewsForVehicleMakeAndModel(@RequestParam(required = false) String make, @RequestParam(required = false) String model){

        Vehicle vehicle = vehicleService.GetByMakeAndModel(make, model);

        return reviewService.GetReviewsForVehicle(vehicle);
    }

    @GetMapping(value = "reviewsCount")
    public HashMap<String, Object> getReviewsCountForVehicleMakeAndModel(@RequestParam(required = false) String make, @RequestParam(required = false) String model){

        Vehicle vehicle = vehicleService.GetByMakeAndModel(make, model);

        int reviewsCount = reviewService.GetReviewsForVehicle(vehicle).size();

        HashMap<String, Object> map = new HashMap<>();
        map.put("reviewsCount", reviewsCount);

        return map;
    }

}