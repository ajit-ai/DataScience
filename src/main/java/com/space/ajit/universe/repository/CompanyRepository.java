package com.space.ajit.universe.repository;

import com.space.ajit.universe.model.company.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company,Integer> {
}
