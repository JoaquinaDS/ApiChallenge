package com.apichallenge.demo.application.mappers;

import com.apichallenge.demo.domain.models.Price;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceEntityMapper {

    @Mapping(source = "entity.price", target = "pvp")
    @Mapping(source = "fee", target = "feePercentage")
    Price entityToDomain(PriceEntity entity, Double fee);

}