package com.learn.jobservice.job;

import com.learn.jobservice.job.dto.JobDTO;

import java.util.List;

/**
 * @author anthonylee
 */
public interface JobService {
    List<JobDTO> getAllJobs();

    Job createJob(Job job);

    JobDTO getJobById(Long id);

    Job updateJob(Long id, Job job);

    boolean deleteJob(Long id);
}
