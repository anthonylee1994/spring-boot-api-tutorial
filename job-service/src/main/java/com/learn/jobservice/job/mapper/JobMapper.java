package com.learn.jobservice.job.mapper;

import com.learn.jobservice.job.Job;
import com.learn.jobservice.job.dto.JobDTO;
import com.learn.jobservice.job.external.Company;
import com.learn.jobservice.job.external.Review;

import java.util.List;

/**
 * @author anthonylee
 */
public class JobMapper {
    public static JobDTO toEntity(Job job, Company company, List<Review> reviews) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setCompany(company);
        jobDTO.setReviews(reviews);
        return jobDTO;
    }
}
