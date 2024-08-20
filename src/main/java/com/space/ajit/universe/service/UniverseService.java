package com.space.ajit.universe.service;

import com.space.ajit.universe.model.universe.Universe;

import java.util.List;
import java.util.Optional;

public interface UniverseService {

    List<Universe> getUniverse();

    Optional<Universe> findById(String id);

    Universe save(Universe universe);

    Universe findByUniverse(String name);

    void delete(Long id);
}
