package com.learn.springbootapitutorial.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    Review addReview(Long companyId, Review review);

    Review getReview(Long reviewId);

    Review updateReview(Long reviewId, Review review);

    boolean deleteReview(Long reviewId);
}
