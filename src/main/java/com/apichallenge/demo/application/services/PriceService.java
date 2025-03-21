package com.apichallenge.demo.application.services;

import com.apichallenge.demo.application.mapper.PriceEntityMapper;
import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.application.port.out.FeeRepositoryPort;
import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import com.apichallenge.demo.domain.exceptions.PriceNotFoundException;
import com.apichallenge.demo.domain.models.Price;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.FeeEntity;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class PriceService implements GetPriceByDateProductAndBrandUseCase {

    private final PriceRepositoryPort priceRepository;
    private final FeeRepositoryPort feeRepository;
    private final PriceEntityMapper mapper;

    /**
     * Process that get Price Data for a specific date, product and brand.
     * In case there is no price for a date, product and brand, the corresponding exception is thrown.
     * In case there is more than one result for a date, product and brand, the selected one is the one with greater priority.
     *
     * @param date      used to filter
     * @param productId used to filter
     * @param brandId   used to filter
     * @return Price with the data.
     */
    @Override
    public Price getPriceByDateProductAndBrandUseCase(final LocalDateTime date, final Long productId, final Long brandId) {
        List<PriceEntity> prices = priceRepository.getBy(date, productId, brandId);
        if (!prices.isEmpty()) {
            return getPriceWithGreaterPriority(prices);
        }
        throw new PriceNotFoundException(productId, brandId);
    }

    /**
     * Given a list of prices, the process returns the one with greater priority.
     *
     * @param prices that whants to be evaluated
     * @return price with greater priority from the list.
     */
    private Price getPriceWithGreaterPriority(final List<PriceEntity> prices) {
        PriceEntity priceWithGreaterPriority = Collections.max(prices, Comparator.comparing(PriceEntity::getPriority));
        FeeEntity feeEntity = feeRepository.getReferenceById(priceWithGreaterPriority.getFeeId());
        return mapper.entityToDomain(priceWithGreaterPriority, feeEntity.getPercentage());
    }

}