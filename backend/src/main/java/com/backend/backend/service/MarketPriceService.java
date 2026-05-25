package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.MarketPrice;
import com.backend.backend.repository.MarketPriceRepository;

@Service
public class MarketPriceService {

    @Autowired
    private MarketPriceRepository markRepo;

    // Get All Market Price
    public List<MarketPrice> getAllPrices() {
        return markRepo.findAll();
    }

    // Search By Crop Name
    public Object getPriceByCrop(String cropName) {

        List<MarketPrice> prices = markRepo.findByCropName(cropName);

        // NO Match Found
        if (prices.isEmpty()) {
            return "No Market Price Found";
        }

        return prices;
    }

}
