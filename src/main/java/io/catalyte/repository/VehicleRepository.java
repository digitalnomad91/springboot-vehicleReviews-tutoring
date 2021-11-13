package io.catalyte.repository;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  Vehicle findByMakeAndModel(String make, String model);
}
