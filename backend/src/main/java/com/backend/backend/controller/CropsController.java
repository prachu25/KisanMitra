package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.entity.Crops;
import com.backend.backend.service.CropsService;

@RestController
@RequestMapping("/api/crops")
public class CropsController {

    @Autowired
    private CropsService cropServ;

    // Get All Crops
    @GetMapping
    public List<Crops> getAllCrops() {
        return cropServ.getAllCrops();
    }

    // Add Crops
    @PostMapping("/add")
    public String addCrop(@RequestBody Crops crop) {
        return cropServ.addCrop(crop);
    }

    // Get Crop By Id
    @GetMapping("/{id}")
    public Crops getCropById(@PathVariable Long id) {
        return cropServ.getCropById(id);
    }

    // Update Crop
    @PutMapping("/update-crop/{id}")
    public String updateCrop(@PathVariable Long id,
            @RequestBody Crops crop) {

        return cropServ.updateCrop(id, crop);
    }

    // Delete Crop
    @DeleteMapping("/delete/{id}")
    public String deleteCrop(@PathVariable Long id) {
        return cropServ.deleteCrop(id);
    }

}
