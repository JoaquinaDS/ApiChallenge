package com.apichallenge.demo.application.services;

import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceService implements GetPriceByDateProductAndBrandUseCase {

    private PriceRepositoryPort repository;

}
