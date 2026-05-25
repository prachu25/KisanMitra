package com.backend.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.entity.MarketPrice;

@Repository
public interface MarketPriceRepository extends JpaRepository<MarketPrice, Long> {

    List<MarketPrice> findByCropName(String cropName);

}