package com.apichallenge.demo.application.port.out;

import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.FeeEntity;

public interface FeeRepositoryPort {

    FeeEntity getReferenceById(Long id);

}
