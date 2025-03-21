package com.apichallenge.demo.application.exceptions;

import com.apichallenge.demo.domain.exceptions.MainException;
import com.apichallenge.demo.domain.exceptions.PriceNotFoundException;
import com.apichallenge.demo.infrastructure.adapter.in.web.dto.RestError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@ControllerAdvice
@Log4j2
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String ERROR_S = "ERROR: %s";

    @ExceptionHandler(value = {
            PriceNotFoundException.class
    })
    public ResponseEntity<Object> handleNotFoundException(final MainException ex, final WebRequest request) {
        final RestError responseBody = createExceptionResponseBody(ex, HttpStatus.NOT_FOUND);
        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private RestError createExceptionResponseBody(final Exception exception, final HttpStatus httpStatus) {
        String errorMessage;
        log.error( String.format( ERROR_S, exception.getMessage() ), exception );
        if (exception instanceof MainException && ((MainException) exception).getErrorMessage() != null) {
            errorMessage = ((MainException) exception).getErrorMessage();
        } else {
            errorMessage = "Unknown error";
        }
        return new RestError(httpStatus.value(), errorMessage);

    }

}
