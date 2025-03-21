package com.apichallenge.demo.infrastructure.config;

import com.apichallenge.demo.application.port.out.FeeRepositoryPort;
import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories.FeeJpaRepository;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories.H2FeeRepository;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories.H2PriceRepository;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories.PriceJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories")
public class RepositoryConfig {

    @Bean
    public PriceRepositoryPort priceRepositoryPort(PriceJpaRepository jpaRepository){
        return new H2PriceRepository(jpaRepository);
    }

    @Bean
    public FeeRepositoryPort feeRepositoryPort(FeeJpaRepository jpaRepository){
        return new H2FeeRepository(jpaRepository);
    }

}