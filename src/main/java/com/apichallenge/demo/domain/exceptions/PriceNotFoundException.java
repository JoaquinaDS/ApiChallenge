package com.apichallenge.demo.domain.exceptions;

import lombok.Getter;

import static com.apichallenge.demo.domain.constants.ExceptionMessage.PRICE_NOT_FOUND_MESSAGE;

@Getter
public class PriceNotFoundException extends MainException {

    public PriceNotFoundException(final Long productId, final Long brandId) {
        super(String.format(PRICE_NOT_FOUND_MESSAGE, productId, brandId));
    }

    public PriceNotFoundException(final Long productId, final Long brandId, Throwable cause) {
        super(String.format(PRICE_NOT_FOUND_MESSAGE, productId, brandId), cause);
    }

}