package com.learn.companyservice.company;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author anthonylee
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
