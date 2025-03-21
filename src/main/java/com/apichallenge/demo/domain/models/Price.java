package com.apichallenge.demo.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder( toBuilder = true )
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private int productId;
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double feePercentage;
    private Double pvp;

}
