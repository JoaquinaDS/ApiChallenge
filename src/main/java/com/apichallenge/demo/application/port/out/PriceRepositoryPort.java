package com.apichallenge.demo.application.port.out;

import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {

    List<PriceEntity> getBy(LocalDateTime date, Long productId, Long brandId);

}