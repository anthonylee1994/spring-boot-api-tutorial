package com.learn.jobservice.job;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface JobRepository extends JpaRepository<Job, Long> {
}
