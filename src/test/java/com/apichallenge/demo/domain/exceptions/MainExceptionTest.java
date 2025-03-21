package com.apichallenge.demo.domain.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainExceptionTest {

    @Test
    void testMainExceptionWithErrorMessage() {
        String errorMessage = "Test error message";

        MainException exception = new MainException(errorMessage);

        assertEquals(errorMessage, exception.getErrorMessage());
        assertEquals(errorMessage, exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testMainExceptionWithErrorMessageAndCause() {
        String errorMessage = "Test error message";
        Throwable cause = new RuntimeException("Cause exception");

        MainException exception = new MainException(errorMessage, cause);

        assertEquals(errorMessage, exception.getErrorMessage());
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}