package com.apichallenge.demo.infrastructure.adapter.out.persistence.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRICES")
public class PriceEntity {

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private Long productId;
    @Nonnull
    private Long brandId;
    @Nonnull
    private LocalDateTime startDate;
    @Nonnull
    private LocalDateTime endDate;
    @Nonnull
    private Long feeId;
    @Nonnull
    private Double price;
    @Nonnull
    private byte priority;

}