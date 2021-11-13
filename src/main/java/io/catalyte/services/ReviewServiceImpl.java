package io.catalyte.services;

import io.catalyte.entities.Review;
import io.catalyte.entities.Vehicle;
import io.catalyte.exceptions.ResourceNotFound;
import io.catalyte.exceptions.ServiceUnavailable;
import io.catalyte.repository.ReviewRepository;
import io.catalyte.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Review> getReviews() {
        List<Review> retReviews = new ArrayList<>();
        try {
            retReviews = reviewRepository.findAll();
            return retReviews;
        } catch (DataAccessException dae) {
            throw new ServiceUnavailable(dae.getMessage());
        }
    }

    @Override
    public Review getReviewById(Long id) {
        Review getReview = null;
        try {
            getReview = reviewRepository.findById(id).orElse(null);
            return getReview;
        } catch (DataAccessException dae) {
            throw new ServiceUnavailable(dae.getMessage());
        }
    }

    public Review addReview(Review review) {
        reviewRepository.save(review);
        return review;

    }

    @Override
    public void removeReview(Long id) {
        try {
            Review reviewToRemove = reviewRepository.findById(id).orElse(null);
            reviewRepository.delete(reviewToRemove);
        } catch (DataAccessException dae) {
            throw new ServiceUnavailable(dae.getMessage());
        }
    }

    @Override
    public Review updateReview(Review newReview) {
        reviewRepository.save(newReview);
        return newReview;
    }

    public List<Review> GetReviewsForVehicle(Vehicle vehicle){

        List<Review> retReviews = new ArrayList<>();

        try {
            retReviews = reviewRepository.findByVehicle(vehicle);

            return  retReviews;

        } catch (DataAccessException dae) {

            throw new ServiceUnavailable(dae.getMessage());
        }

    }

}







