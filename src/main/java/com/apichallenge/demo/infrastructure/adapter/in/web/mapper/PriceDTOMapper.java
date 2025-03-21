package com.apichallenge.demo.infrastructure.adapter.in.web.mapper;

import com.apichallenge.demo.domain.models.Price;
import com.apichallenge.demo.infrastructure.adapter.in.web.dto.PriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.apichallenge.demo.infrastructure.adapter.in.web.constants.DateConstants.DATE_PATTERN;

@Mapper
public interface PriceDTOMapper {

    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "brandId", source = "brandId")
    @Mapping(target = "startDate", source = "startDate", qualifiedByName = "localDateTimeToString")
    @Mapping(target = "endDate", source = "endDate",qualifiedByName = "localDateTimeToString")
    @Mapping(target = "feePercentage", source = "feePercentage")
    @Mapping(target = "pvp", source = "pvp")
    PriceDTO domainToDTO(Price domain);

    @Named("localDateTimeToString")
    default String localDateTimeToString(LocalDateTime date) {
        if (date != null) {
            return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
        }
        return null;
    }

}