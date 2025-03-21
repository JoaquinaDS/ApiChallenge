package com.apichallenge.demo.infrastructure.adapter.in.web;

import com.apichallenge.demo.application.port.in.GetPriceByDateProductAndBrandUseCase;
import com.apichallenge.demo.domain.models.Price;
import com.apichallenge.demo.infrastructure.adapter.in.web.dto.PriceDTO;
import com.apichallenge.demo.infrastructure.adapter.in.web.mapper.PriceDTOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PriceControllerTest {

    @Mock
    private GetPriceByDateProductAndBrandUseCase getPriceByDateProductAndBrandUseCase;
    @Mock
    private PriceDTOMapper mapper;

    @InjectMocks
    private PriceController sut;

    private final PriceDTO response = mock(PriceDTO.class);
    private final Price domain = mock(Price.class);
    private final Long ID = 1L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    void givenDateProductIdAndBrandIdWhenGetByThenReturnsResponseDto() {
        when(getPriceByDateProductAndBrandUseCase.getPriceByDateProductAndBrandUseCase(any(LocalDateTime.class), eq(ID), eq(ID))).thenReturn(domain);
        when(mapper.domainToDTO(domain)).thenReturn(response);

        ResponseEntity<PriceDTO> result = sut.getBy(OffsetDateTime.now(), ID, ID);

        assertThat(result.getBody()).isEqualTo(response);
        verify(getPriceByDateProductAndBrandUseCase, times(1)).getPriceByDateProductAndBrandUseCase(any(LocalDateTime.class), eq(ID),eq(ID));
        verify(mapper, times(1)).domainToDTO(domain);
    }

}