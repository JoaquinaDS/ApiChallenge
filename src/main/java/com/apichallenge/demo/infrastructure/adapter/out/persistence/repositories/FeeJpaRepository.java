package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;

import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.FeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FeeJpaRepository  extends JpaRepository<FeeEntity, Long> {
}