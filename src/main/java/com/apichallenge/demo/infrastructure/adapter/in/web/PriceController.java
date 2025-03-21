package com.apichallenge.demo.infrastructure.adapter.in.web;

import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.infrastructure.adapter.in.web.dto.PriceDTO;
import com.apichallenge.demo.infrastructure.adapter.in.web.mapper.PriceDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@RequiredArgsConstructor
@RestController
public class PriceController implements PriceApi {

    @Autowired
    private GetPriceByDateProductAndBrandUseCase getPriceByDateProductAndBrandUseCase;
    @Autowired
    private PriceDTOMapper mapper;

    @Override
    public ResponseEntity<PriceDTO> getBy(OffsetDateTime date, Long productId, Long brandId) {
        LocalDateTime localDateTime = date.toLocalDateTime();
        PriceDTO response = mapper.domainToDTO(getPriceByDateProductAndBrandUseCase.getPriceByDateProductAndBrandUseCase(localDateTime, productId, brandId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}