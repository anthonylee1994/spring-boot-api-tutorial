package com.learn.springbootapitutorial.job;

import java.util.List;

/**
 * @author anthonylee
 */
public interface JobService {
    List<Job> findAll();

    Job createJob(Job job);

    Job getJobById(Long id);

    Job updateJob(Long id, Job job);

    boolean deleteJob(Long id);
}
