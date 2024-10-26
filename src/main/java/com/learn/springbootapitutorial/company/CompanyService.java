package com.learn.springbootapitutorial.company;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anthonylee
 */
@Service
public interface CompanyService {
    List<Company> getAllCompanies();

    Company createCompany(Company company);

    Company getCompanyById(Long id);

    Company updateCompany(Long id, Company company);

    boolean deleteCompany(Long id);
}
