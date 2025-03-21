package com.apichallenge.demo.infrastructure.config;

import com.apichallenge.demo.application.port.out.FeeRepositoryPort;
import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories.FeeJpaRepository;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories.PriceJpaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryConfigTest {

    @Mock
    private PriceJpaRepository priceJpaRepository;
    @Mock
    private FeeJpaRepository feeJpaRepository;

    private final RepositoryConfig config = new RepositoryConfig();

    @Test
    public void testPriceRepositoryPort() {
        PriceRepositoryPort priceRepositoryPort = config.priceRepositoryPort(priceJpaRepository);

        assertNotNull(priceRepositoryPort);
    }

    @Test
    public void testFeeRepositoryPort() {
        FeeRepositoryPort feeRepositoryPort = config.feeRepositoryPort(feeJpaRepository);

        assertNotNull(feeRepositoryPort);
    }

}