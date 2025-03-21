package com.apichallenge.demo.application.services;

import com.apichallenge.demo.application.mapper.PriceEntityMapper;
import com.apichallenge.demo.application.port.out.FeeRepositoryPort;
import com.apichallenge.demo.application.port.out.PriceRepositoryPort;
import com.apichallenge.demo.domain.exceptions.PriceNotFoundException;
import com.apichallenge.demo.domain.models.Price;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.FeeEntity;
import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.apichallenge.demo.domain.constants.ExceptionMessage.PRICE_NOT_FOUND_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PriceServiceTest {

    @Mock
    private PriceRepositoryPort priceRepositoryPort;
    @Mock
    private FeeRepositoryPort feeRepositoryPort;
    @Mock
    private PriceEntityMapper priceEntityMapper;

    @InjectMocks
    private PriceService sut;

    private final PriceEntity priceEntity = mock(PriceEntity.class);
    private final FeeEntity feeEntity = mock(FeeEntity.class);
    private final Price price = mock(Price.class);
    private final Long ID = 1L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    void givenValidData_whenGetPriceByDateProductAndBrandUseCase_thenReturnPrice(){
        final byte PRIORITY = 1;
        final Double PERCENTAGE = 10.00;
        List<PriceEntity> priceList = new ArrayList<>();
        priceList.add(priceEntity);
        when(priceEntity.getPriority()).thenReturn(PRIORITY);
        when(priceEntity.getFeeId()).thenReturn( ID );
        when(feeEntity.getPercentage()).thenReturn(PERCENTAGE);
        when(priceRepositoryPort.getBy(any(), eq(ID), eq(ID))).thenReturn(priceList);
        when(feeRepositoryPort.getReferenceById(ID)).thenReturn(feeEntity);
        when(priceEntityMapper.entityToDomain(priceEntity, PERCENTAGE)).thenReturn(price);

        final Price result = sut.getPriceByDateProductAndBrandUseCase(LocalDateTime.now(), ID, ID);

        assertEquals(price, result);
        verify(priceRepositoryPort, times(1)).getBy(any(),eq(ID),eq(ID));
        verify(feeRepositoryPort, times(1)).getReferenceById(ID);
        verify(priceEntityMapper, times(1)).entityToDomain(priceEntity, PERCENTAGE);
    }

    @Test
    void givenInvalidData_whenGetPriceByDateProductAndBrandUseCase_thenThrowException(){
        List<PriceEntity> priceList = new ArrayList<>();
        when(priceRepositoryPort.getBy(any(), eq(ID), eq(ID))).thenReturn(priceList);

        try{
            sut.getPriceByDateProductAndBrandUseCase(LocalDateTime.now(), ID, ID);
            fail("Exception expected");
        }catch (PriceNotFoundException exception){
            assertThat(exception).hasMessageContaining(String.format(PRICE_NOT_FOUND_MESSAGE, ID, ID));
            verify(priceRepositoryPort, times(1)).getBy(any(),eq(ID),eq(ID));
            verify(feeRepositoryPort, never()).getReferenceById(any());
            verify(priceEntityMapper, never()).entityToDomain(any(),any());
        }
    }

}