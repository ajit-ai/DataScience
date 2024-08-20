package com.space.ajit.universe.service.impl;

import com.space.ajit.universe.model.company.Company;
import com.space.ajit.universe.repository.CompanyRepository;
import com.space.ajit.universe.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getCompany() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return null;
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company findByCompany(String name) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
    /*@Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDetails> getUserDetails() {
        return (List<UserDetails>) userRepository.findAll();
    }

    @Override
    public UserDetails findById(Long id) {
        return null;
    }

    @Override
    public UserDetails save(UserDetails user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }*/
}
