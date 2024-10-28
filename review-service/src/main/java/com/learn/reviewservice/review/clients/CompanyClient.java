package com.learn.reviewservice.review.clients;

import com.learn.reviewservice.review.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author anthonylee
 */
@FeignClient(name = "COMPANY-SERVICE", url = "${company-service.url}")
public interface CompanyClient {
    @GetMapping("/companies/{id}")
    Company getCompanyById(@PathVariable("id") Long id);
}
