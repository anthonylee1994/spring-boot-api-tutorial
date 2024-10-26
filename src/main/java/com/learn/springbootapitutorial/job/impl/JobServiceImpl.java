package com.learn.springbootapitutorial.job.impl;

import com.learn.springbootapitutorial.job.Job;
import com.learn.springbootapitutorial.job.JobRepository;
import com.learn.springbootapitutorial.job.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anthonylee
 */
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
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
        existingJob.setCompany(job.getCompany());
        return jobRepository.save(existingJob);
    }

    @Override
    public boolean deleteJob(Long id) {
        Job existingJob = getJobById(id);
        if (existingJob == null) {
            return false;
        }
        jobRepository.delete(existingJob);
        return true;
    }
}
