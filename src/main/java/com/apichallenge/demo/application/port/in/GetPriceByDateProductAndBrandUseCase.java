package com.apichallenge.demo.application.port.in;

import com.apichallenge.demo.domain.models.Price;
import java.time.LocalDateTime;

public interface GetPriceByDateProductAndBrandUseCase {

    Price getPriceByDateProductAndBrandUseCase(LocalDateTime date, Long productId, Long brandId);

}