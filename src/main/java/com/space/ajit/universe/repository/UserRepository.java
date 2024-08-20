package com.space.ajit.universe.repository;

import com.space.ajit.universe.model.universe.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDetails, Long> {

    UserDetails findByEmail(String email);

}
