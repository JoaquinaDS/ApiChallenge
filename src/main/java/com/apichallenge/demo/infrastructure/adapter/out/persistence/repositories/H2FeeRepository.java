package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;

import com.apichallenge.demo.application.port.out.FeeRepositoryPort;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.FeeEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class H2FeeRepository implements FeeRepositoryPort {

    private final FeeJpaRepository repository;

    @Override
    public FeeEntity getReferenceById(final Long id) {
        return repository.getReferenceById(id);
    }

}