package com.backend.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.entity.Fertilizer;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

    List<Fertilizer> findByCropTypeAndSoilType(String cropType,
            String soilType);

}
