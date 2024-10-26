package com.learn.companyservice.company.impl;

import com.learn.companyservice.company.Company;
import com.learn.companyservice.company.CompanyRepository;
import com.learn.companyservice.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anthonylee
 */
@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Company existingCompany = getCompanyById(id);
        if (existingCompany == null) {
            return null;
        }
        existingCompany.setName(company.getName());
        existingCompany.setDescription(company.getDescription());

        companyRepository.save(existingCompany);

        return existingCompany;
    }

    @Override
    public boolean deleteCompany(Long id) {
        Company existingCompany = getCompanyById(id);
        if (existingCompany == null) {
            return false;
        }
        companyRepository.delete(existingCompany);
        return true;
    }
}
