package com.learn.springbootapitutorial.review.impl;

import com.learn.springbootapitutorial.company.Company;
import com.learn.springbootapitutorial.company.CompanyService;
import com.learn.springbootapitutorial.review.Review;
import com.learn.springbootapitutorial.review.ReviewRepository;
import com.learn.springbootapitutorial.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            return reviewRepository.save(review);
        }

        return null;
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
