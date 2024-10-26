package com.learn.jobservice.job.dto;

import com.learn.jobservice.job.external.Company;
import com.learn.jobservice.job.external.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author anthonylee
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobDTO {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    private Company company;
    private List<Review> reviews;
}
