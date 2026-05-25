package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.Fertilizer;
import com.backend.backend.service.FertilizerService;

@RestController
@RequestMapping("/api/fertilizers")
public class FertilizerController {

    @Autowired
    private FertilizerService fertserv;

    // Get All Fertilizers
    @GetMapping
    public List<Fertilizer> getAllFertilizers() {
        return fertserv.getAllFertilizers();
    }

    // Get Fertilizer Recommendation
    @GetMapping("/recommend") // http://localhost:8080/api/fertilizers/recommend?cropType=Cotton&soilType=RedSoil
    public Object gettRecommendation(
            @RequestParam String cropType,
            @RequestParam String soilType) {

        return fertserv.getRecommendation(cropType, soilType);
    }

}
