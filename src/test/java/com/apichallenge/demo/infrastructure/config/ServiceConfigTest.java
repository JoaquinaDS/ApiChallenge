package com.apichallenge.demo.infrastructure.config;

import com.apichallenge.demo.application.mapper.PriceEntityMapper;
import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.application.port.out.FeeRepositoryPort;
import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ServiceConfigTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;
    @Mock
    private FeeRepositoryPort feeRepositoryPort;
    @Mock
    private PriceEntityMapper priceEntityMapper;

    private final ServiceConfig config = new ServiceConfig();

    @Test
    public void testGetPriceByDateProductAndBrandUseCase() {
        GetPriceByDateProductAndBrandUseCase useCase = config.getPriceByDateProductAndBrandUseCase(priceRepositoryPort,
                feeRepositoryPort, priceEntityMapper);

        assertNotNull(useCase);
    }

}