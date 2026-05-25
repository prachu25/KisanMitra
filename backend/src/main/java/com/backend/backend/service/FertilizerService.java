package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.Fertilizer;
import com.backend.backend.repository.FertilizerRepository;

@Service
public class FertilizerService {

    @Autowired
    private FertilizerRepository fertRepo;

    // Get All Fertilizers
    public List<Fertilizer> getAllFertilizers() {
        return fertRepo.findAll();
    }

    // Get Fertilizer Recommendation
    public Object getRecommendation(String cropType, String SoilType) {

        List<Fertilizer> fertilizers = fertRepo.findByCropTypeAndSoilType(cropType, SoilType);

        // No Maatch Found
        if (fertilizers.isEmpty()) {
            return "No Fertilizer Recommendation Found";
        }

        return fertilizers;
    }

}
