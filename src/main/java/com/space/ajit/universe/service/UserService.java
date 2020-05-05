/**
 *
 */
package com.space.ajit.universe.service;

import com.space.ajit.universe.model.universe.UserDetails;

import java.util.List;

public interface UserService {

    List<UserDetails> getUserDetails();

    UserDetails findById(Long id);

    UserDetails save(UserDetails user);

    UserDetails findByEmail(String email);

    void delete(Long id);
}
