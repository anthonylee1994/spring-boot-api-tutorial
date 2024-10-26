package com.learn.springbootapitutorial.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anthonylee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
}
