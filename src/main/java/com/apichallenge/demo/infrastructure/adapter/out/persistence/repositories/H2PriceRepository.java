package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;


import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class H2PriceRepository implements PriceRepositoryPort {

    private PriceJpaRepository repository;

}