package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;

import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class H2PriceRepository implements PriceRepositoryPort {

    private final PriceJpaRepository repository;

    @Override
    public List<PriceEntity> getBy(final LocalDateTime date, final Long productId, final Long brandId) {
        return repository.getBy(date, productId, brandId);
    }

}