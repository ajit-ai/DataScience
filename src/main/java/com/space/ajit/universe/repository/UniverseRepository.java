package com.space.ajit.universe.repository;

import com.space.ajit.universe.model.universe.Universe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverseRepository extends MongoRepository<Universe,String> {
}
