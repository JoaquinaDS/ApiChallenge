package com.apichallenge.demo.application.exceptions;

import com.apichallenge.demo.domain.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith( MockitoExtension.class )
class CustomResponseEntityExceptionHandlerTest {

    @Mock
    private WebRequest webRequest;
    @InjectMocks
    private CustomResponseEntityExceptionHandler handler;

    @Test
    void testHandleNotFoundException() {
        final Long LONG_ID = 1L;
        PriceNotFoundException exception = new PriceNotFoundException( LONG_ID, LONG_ID);

        final ResponseEntity< Object > response = this.handler.handleNotFoundException( exception, webRequest );

        assertNotNull( response );
    }

}