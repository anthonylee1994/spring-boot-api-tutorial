package com.learn.jobservice.job.impl;

import com.learn.jobservice.job.Job;
import com.learn.jobservice.job.JobRepository;
import com.learn.jobservice.job.JobService;
import com.learn.jobservice.job.clients.CompanyClient;
import com.learn.jobservice.job.clients.ReviewClient;
import com.learn.jobservice.job.dto.JobDTO;
import com.learn.jobservice.job.external.Company;
import com.learn.jobservice.job.external.Review;
import com.learn.jobservice.job.mapper.JobMapper;
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
    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::convertToDto).toList();
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public JobDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job == null) {
            return null;
        }
        return convertToDto(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Job existingJob = jobRepository.findById(id).orElse(null);
        if (existingJob == null) {
            return null;
        }
        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        existingJob.setMinSalary(job.getMinSalary());
        existingJob.setMaxSalary(job.getMaxSalary());
        existingJob.setLocation(job.getLocation());

        return jobRepository.save(existingJob);
    }

    @Override
    public boolean deleteJob(Long id) {
        Job existingJob = jobRepository.findById(id).orElse(null);
        if (existingJob == null) {
            return false;
        }
        jobRepository.delete(existingJob);
        return true;
    }

    private JobDTO convertToDto(Job job) {
        Company company = companyClient.getCompanyById(job.getCompanyId());
        List<Review> reviews = reviewClient.getReviews(job.getCompanyId());
        return JobMapper.toEntity(job, company, reviews);
    }
}
