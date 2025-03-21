package com.apichallenge.demo.e2e.prices;

import com.apichallenge.demo.e2e.DefaultE2ETest;
import com.apichallenge.demo.infrastructure.adapter.in.web.dto.PriceDTO;
import com.apichallenge.demo.infrastructure.adapter.in.web.dto.RestError;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.text.ParseException;

import static com.apichallenge.demo.domain.constants.ExceptionMessage.PRICE_NOT_FOUND_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;


public class PriceE2ETest extends DefaultE2ETest {

    private final Long ID = 1L;

    @Test
    void givenDateProductAndBrand_whenGetBy_ThenReturnsPriceResponse_v1() {
        final PriceDTO expectedResponse = PriceDTO.builder()
                .productId(ID)
                .brandId(ID)
                .startDate("2020-06-14 00:00:00")
                .endDate("2020-12-31 23:59:59")
                .feePercentage(0.0)
                .pvp(35.5)
                .build();

        webClient.get().uri(uriBuilder ->
                        generateURI(uriBuilder, "2020-06-14T10:00:00Z", 1, 1))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(PriceDTO.class)
                .consumeWith(response -> {
                    PriceDTO actualResponse = response.getResponseBody();
                    assertThat(actualResponse).isEqualTo(expectedResponse);
                });
    }

    @Test
    void givenDateProductAndBrand_whenGetBy_ThenReturnsPriceResponse_v2() {
        final PriceDTO expectedResponse = PriceDTO.builder()
                .productId(ID)
                .brandId(ID)
                .startDate("2020-06-14 15:00:00")
                .endDate("2020-06-14 18:30:00")
                .feePercentage(10.0)
                .pvp(25.45)
                .build();

        webClient.get().uri(uriBuilder ->
                        generateURI(uriBuilder, "2020-06-14T16:00:00Z", 1, 1))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(PriceDTO.class)
                .consumeWith(response -> {
                    PriceDTO actualResponse = response.getResponseBody();
                    assertThat(actualResponse).isEqualTo(expectedResponse);
                });
    }

    @Test
    void givenDateProductAndBrand_whenGetBy_ThenReturnsPriceResponse_v3() {
        final PriceDTO expectedResponse = PriceDTO.builder()
                .productId(ID)
                .brandId(ID)
                .startDate("2020-06-14 00:00:00")
                .endDate("2020-12-31 23:59:59")
                .feePercentage(0.0)
                .pvp(35.5)
                .build();

        webClient.get().uri(uriBuilder ->
                        generateURI(uriBuilder, "2020-06-14T21:00:00Z", 1, 1))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(PriceDTO.class)
                .consumeWith(response -> {
                    PriceDTO actualResponse = response.getResponseBody();
                    assertThat(actualResponse).isEqualTo(expectedResponse);
                });
    }

    @Test
    void givenDateProductAndBrand_whenGetBy_ThenReturnsPriceResponse_v4() {
        final PriceDTO expectedResponse = PriceDTO.builder()
                .productId(ID)
                .brandId(ID)
                .startDate("2020-06-15 00:00:00")
                .endDate("2020-06-15 11:00:00")
                .feePercentage(20.0)
                .pvp(30.5)
                .build();

        webClient.get().uri(uriBuilder ->
                        generateURI(uriBuilder, "2020-06-15T10:00:00Z", 1, 1))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(PriceDTO.class)
                .consumeWith(response -> {
                    PriceDTO actualResponse = response.getResponseBody();
                    assertThat(actualResponse).isEqualTo(expectedResponse);
                });
    }

    @Test
    void givenDateProductAndBrand_whenGetBy_ThenReturnsPriceResponse_v5() {
        final PriceDTO expectedResponse = PriceDTO.builder()
                .productId(ID)
                .brandId(ID)
                .startDate("2020-06-15 16:00:00")
                .endDate("2020-12-31 23:59:59")
                .feePercentage(30.0)
                .pvp(38.95)
                .build();

        webClient.get().uri(uriBuilder ->
                        generateURI(uriBuilder, "2020-06-16T21:00:00Z", 1, 1))
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(PriceDTO.class)
                .consumeWith(response -> {
                    PriceDTO actualResponse = response.getResponseBody();
                    assertThat(actualResponse).isEqualTo(expectedResponse);
                });
    }

    @Test
    void givenNonExistingData_whenGetBy_ThenThrowsNotFoundException() {
        final int invalidId = 999;
        final RestError expectedResponse = RestError.builder()
                .code(404)
                .message(String.format(PRICE_NOT_FOUND_MESSAGE, invalidId, invalidId))
                .build();

        webClient.get().uri(uriBuilder ->
                        generateURI(uriBuilder, "2020-06-16T21:00:00Z", invalidId, invalidId))
                .exchange()
                .expectStatus()
                .isNotFound()
                .expectBody(RestError.class)
                .consumeWith(response -> {
                    RestError actualResponse = response.getResponseBody();
                    assertThat(actualResponse).isEqualTo(expectedResponse);
                });
    }

    private URI generateURI(UriBuilder uriBuilder, String date, int productId, int brandId) {
        String path = "/price";
        return uriBuilder
                .path(path)
                .queryParam("date", date)
                .queryParam("productId", productId)
                .queryParam("brandId", brandId)
                .build();
    }

}