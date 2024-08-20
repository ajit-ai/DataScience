package com.space.ajit.universe.service;

import com.space.ajit.universe.model.company.Company;
import com.space.ajit.universe.model.universe.UserDetails;

import java.util.List;

public interface CompanyService {

    List<Company> getCompany();

    Company findById(Long id);

    Company save(Company company);

    Company findByCompany(String name);

    void delete(Long id);
}
