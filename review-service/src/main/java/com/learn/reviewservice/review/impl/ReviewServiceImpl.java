package com.learn.reviewservice.review.impl;

import com.learn.reviewservice.review.Review;
import com.learn.reviewservice.review.ReviewRepository;
import com.learn.reviewservice.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        review.setCompanyId(companyId);
        return reviewRepository.save(review);
    }

    @Override
    public Review getReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public Review updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review == null) return null;

        review.setTitle(updatedReview.getTitle());
        review.setDescription(updatedReview.getDescription());
        review.setRating(updatedReview.getRating());
        review.setCompanyId(updatedReview.getCompanyId());
        return reviewRepository.save(review);
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review == null) return false;

        reviewRepository.delete(review);
        return true;
    }
}
