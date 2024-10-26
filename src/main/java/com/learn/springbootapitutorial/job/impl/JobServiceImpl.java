package com.learn.springbootapitutorial.job.impl;

import com.learn.springbootapitutorial.job.Job;
import com.learn.springbootapitutorial.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anthonylee
 */
@Service
public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();
    private  Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public Job createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return job;
    }

    @Override
    public Job getJobById(Long id) {
        return jobs.stream()
                .filter(job -> job.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Job existingJob = getJobById(id);
        if (existingJob == null) {
            return null;
        }
        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setMinSalary(job.getMinSalary());
        existingJob.setMaxSalary(job.getMaxSalary());
        existingJob.setLocation(job.getLocation());

        return existingJob;
    }

    @Override
    public boolean deleteJob(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }
}
