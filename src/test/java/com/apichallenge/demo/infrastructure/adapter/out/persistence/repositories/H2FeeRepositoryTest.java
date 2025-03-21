package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;


import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.FeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class H2FeeRepositoryTest {

    @Mock
    private FeeJpaRepository feeJpaRepository;

    @InjectMocks
    private H2FeeRepository sut;

    private final FeeEntity feeEntity = mock(FeeEntity.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    void givenId_whenGetReferenceById_thenCallRepositoryAndReturnResult(){
        final Long ID = 1L;
        when(feeJpaRepository.getReferenceById(ID)).thenReturn(feeEntity);

        final FeeEntity result = sut.getReferenceById(ID);

        assertEquals(feeEntity, result);
        verify(feeJpaRepository, times(1)).getReferenceById(ID);
    }

}