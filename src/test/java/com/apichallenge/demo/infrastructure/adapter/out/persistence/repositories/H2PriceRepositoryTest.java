package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;

import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class H2PriceRepositoryTest {

    @Mock
    private PriceJpaRepository priceJpaRepository;

    @InjectMocks
    private H2PriceRepository sut;

    private final PriceEntity priceEntity = mock(PriceEntity.class);
    private final List<PriceEntity> priceEntityList = Collections.singletonList(priceEntity);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    void givenId_whenGetBy_thenCallRepositoryAndReturnResult(){
        final Long ID = 1L;
        when(priceJpaRepository.getBy(any(LocalDateTime.class), eq(ID), eq(ID))).thenReturn(priceEntityList);

        final List<PriceEntity> result = sut.getBy(LocalDateTime.now(), ID, ID);

        assertEquals(priceEntityList, result);
        verify(priceJpaRepository, times(1)).getBy(any(LocalDateTime.class), eq(ID), eq(ID));
    }


}