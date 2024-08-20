package com.space.ajit.universe.service.impl;

import com.space.ajit.universe.model.universe.Universe;
import com.space.ajit.universe.repository.UniverseRepository;
import com.space.ajit.universe.service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniverseServiceImpl implements UniverseService {

    @Autowired
    UniverseRepository universeRepository;

    @Override
    public List<Universe> getUniverse() {

        return (List<Universe>)universeRepository.findAll();
    }

    @Override
    public Optional<Universe> findById(String id) {
        return  universeRepository.findById(id);
    }

    @Override
    public Universe save(Universe universe) {
        return universeRepository.save(universe);
    }

    @Override
    public Universe findByUniverse(String name) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
