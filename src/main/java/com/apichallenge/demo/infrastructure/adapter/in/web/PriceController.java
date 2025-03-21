package com.apichallenge.demo.infrastructure.adapter.in.web;

import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.infrastructure.adapter.in.web.dto.PriceDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class PriceController implements PriceApi {

    private GetPriceByDateProductAndBrandUseCase getPriceByDateProductAndBrandUseCase;

    @Override
    public ResponseEntity<PriceDTO> get(){
        return null;
    }

}