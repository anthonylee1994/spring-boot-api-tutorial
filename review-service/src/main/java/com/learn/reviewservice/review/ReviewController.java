package com.learn.reviewservice.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping()
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam("companyId") Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Review> addReview(@RequestParam("companyId") Long companyId, @RequestBody Review review) {
        Review addedReview = reviewService.addReview(companyId, review);
        if (addedReview != null) return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable("reviewId") Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);

    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable("reviewId") Long reviewId, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(reviewId, review);
        if (updatedReview != null) return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable("reviewId") Long reviewId) {
        boolean isReviewDeleted = reviewService.deleteReview(reviewId);
        if (isReviewDeleted) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
