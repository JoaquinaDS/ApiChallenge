package com.apichallenge.demo.infrastructure.adapter.out.persistence.repositories;

import com.apichallenge.demo.infrastructure.adapter.out.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT " +
            "P.ID, PRODUCT_ID, BRAND_ID, START_DATE, END_DATE, F.ID AS FEE_ID, F.PERCENTAGE AS FEE_PERCENTAGE, " +
            "P.PRIORITY, P.PRICE " +
            "FROM  " +
            "PRICES P, FEES F " +
            "WHERE " +
            "((?1 BETWEEN P.START_DATE AND P.END_DATE) AND P.PRODUCT_ID = ?2 AND P.BRAND_ID = ?3) " +
            "AND FEE_ID = F.ID", nativeQuery = true)
    List<PriceEntity> getBy(LocalDateTime date, Long productId, Long brandId);

}