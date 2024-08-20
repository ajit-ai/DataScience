/**
 *
 */
package com.space.ajit.universe.service.impl;

import com.space.ajit.universe.repository.UserRepository;
import com.space.ajit.universe.model.universe.UserDetails;
import com.space.ajit.universe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
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
    }

}
