package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.MarketPrice;
import com.backend.backend.service.MarketPriceService;

@RestController
@RequestMapping("/api/market")
public class MarketPriceController {

    @Autowired
    private MarketPriceService markServ;

    // Get All Market Prices
    @GetMapping
    public List<MarketPrice> getAllPrices() {
        return markServ.getAllPrices();
    }

    // Search Market Price By Crop Name
    @GetMapping("/search")
    public Object getPriceByCrop(@RequestParam String cropName) {
        return markServ.getPriceByCrop(cropName);
    }

}
