package io.catalyte.data;

import io.catalyte.entities.Review;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;
import io.catalyte.repository.ReviewRepository;
import io.catalyte.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Vehicle vehicle3;
    private Vehicle vehicle4;

    private Review review1;
    private Review review2;
    private Review review3;
    private Review review4;
    private Review review5;
    private Review review6;
    private Review review7;
    private Review review8;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Loading data...");

        loadVehicles();
        loadReviews();
    }
    private void loadVehicles() {
        vehicle1 = vehicleRepository.save(new Vehicle(1L, "car", "Chevrolet", "Malibu", 2021L));
        vehicle2 = vehicleRepository.save(new Vehicle(2L, "SUV", "Honda", "CR-V", 2021L));
        vehicle3 = vehicleRepository.save(new Vehicle(3L, "truck", "Ford", "F-150", 2020L));
        vehicle4 = vehicleRepository.save(new Vehicle(4L, "car", "Kia", "Optima", 2019L));
    }
    private void loadReviews(){
        review1 = reviewRepository.save(new Review(1L, "0001", "Brand New", 99, "2019",
            "MSlack144",1L, vehicle1));
        review2 = reviewRepository.save(new Review(2L, "0002", "Almost New", 93, "2018",
            "AFranklin144",2L, vehicle2));
        review3 = reviewRepository.save(new Review(3L, "0003", "Somewhat New", 90, "2017",
            "JohnSmith122",3L, vehicle3));
        review4 = reviewRepository.save(new Review(4L, "0004", "Newish", 87, "2016",
            "JaneSmith100",4L, vehicle4));
        review5 = reviewRepository.save(new Review(5L, "0005", "Somewhat Used", 85, "2015",
            "JamesFranklin111", 5L, vehicle4));
        review6 = reviewRepository.save(new Review(6L, "0006", "Used", 80, "2014",
            "ChuckSlack", 6L, vehicle4));
        review7 = reviewRepository.save(new Review(7L, "0007", "Beat up", 75, "2013",
            "BobbyFranks",7L, vehicle4));
        review8 = reviewRepository.save(new Review(8L, "0008", "Trashed", 70, "2012",
            "EleanorSlack", 8L, vehicle4));
    }
}
