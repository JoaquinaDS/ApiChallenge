package com.apichallenge.demo.domain.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessage {

    public static final String PRICE_NOT_FOUND_MESSAGE = "No price found for product %d of brand %d on the given date";

}