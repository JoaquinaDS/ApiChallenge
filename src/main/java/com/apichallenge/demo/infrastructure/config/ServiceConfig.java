package com.apichallenge.demo.infrastructure.config;


import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import com.apichallenge.demo.application.services.PriceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public GetPriceByDateProductAndBrandUseCase getPriceByDateProductAndBrandUseCase(PriceRepositoryPort priceRepositoryPort) {
        return new PriceService(priceRepositoryPort);
    }

}