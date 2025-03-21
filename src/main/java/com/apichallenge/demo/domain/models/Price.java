package com.apichallenge.demo.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder( toBuilder = true )
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private int productId;
    private int brandId;
    private Date startDate;
    private Date endDate;
    private Double feePercentage;
    private Double pvp;

}
