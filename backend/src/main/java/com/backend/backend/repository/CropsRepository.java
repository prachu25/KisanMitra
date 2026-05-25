package com.backend.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.backend.entity.Crops;

@Repository
public interface CropsRepository extends JpaRepository<Crops, Long> {

}
