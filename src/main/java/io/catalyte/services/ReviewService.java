package io.catalyte.services;

import io.catalyte.entities.Review;

import io.catalyte.entities.Vehicle;
import java.util.List;

public interface ReviewService {
    List<Review> getReviews() ;
    Review getReviewById(Long id);
    Review addReview(Review review);
    void removeReview(Long id);
    Review updateReview(Review review);
    List<Review> GetReviewsForVehicle(Vehicle vehicle);
}
