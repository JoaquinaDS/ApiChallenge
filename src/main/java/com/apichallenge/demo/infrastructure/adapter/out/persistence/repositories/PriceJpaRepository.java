package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;


import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {
}
