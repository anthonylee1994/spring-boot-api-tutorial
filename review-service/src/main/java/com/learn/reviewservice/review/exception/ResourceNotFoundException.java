package com.learn.reviewservice.review.exception;

/**
 * @author anthonylee
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
