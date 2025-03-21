package com.apichallenge.demo.infrastructure.config;


import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.infrastructure.adapter.in.web.PriceApi;
import com.apichallenge.demo.infrastructure.adapter.in.web.PriceController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public PriceApi priceController(GetPriceByDateProductAndBrandUseCase getPriceByDateProductAndBrandUseCase) {
        return new PriceController(getPriceByDateProductAndBrandUseCase);
    }

}