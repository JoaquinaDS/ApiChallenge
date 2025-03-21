package com.apichallenge.demo.domain.exceptions;

import org.junit.jupiter.api.Test;

import static com.apichallenge.demo.domain.constants.ExceptionMessage.PRICE_NOT_FOUND_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class PriceNotFoundExceptionTest {

    private final Long ID = 1L;

    @Test
    void testPriceNotFoundExceptionWithParams() {
        String expectedMessage = String.format(PRICE_NOT_FOUND_MESSAGE, ID, ID);

        PriceNotFoundException exception = new PriceNotFoundException(ID, ID);

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testPriceNotFoundExceptionWithCause() {
        Throwable cause = new RuntimeException("Database connection failed");
        String expectedMessage = String.format(PRICE_NOT_FOUND_MESSAGE, ID, ID);

        PriceNotFoundException exception = new PriceNotFoundException(ID, ID, cause);

        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}