package com.learn.jobservice.job.exception;

/**
 * @author anthonylee
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
