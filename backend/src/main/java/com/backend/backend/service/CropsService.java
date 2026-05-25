package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.Crops;
import com.backend.backend.repository.CropsRepository;

@Service
public class CropsService {

    @Autowired
    private CropsRepository cropRepo;

    // Get All crops
    public List<Crops> getAllCrops() {
        return cropRepo.findAll();
    }

    public String addCrop(Crops crop) {

        // Crop Validation
        if (crop.getCropName() == null || crop.getCropName().isEmpty()) {
            return "crop Name is Required";
        }

        // Soil Type Validation
        if (crop.getSoilType() == null || crop.getSoilType().isEmpty()) {
            return "Soil Type is Required";
        }

        // Season Validation
        if (crop.getSeason() == null || crop.getSeason().isEmpty()) {
            return "Season is Required";
        }

        cropRepo.save(crop);

        return "Crop Added Successfully";
    }

    // Get Crop By Id
    public Crops getCropById(Long id) {
        return cropRepo.findById(id).orElse(null);
    }

    // Update Crop
    public String updateCrop(Long id, Crops updateCrop) {

        Crops existingCrops = cropRepo.findById(id).orElse(null);

        if (existingCrops == null) {
            return "Crop Not Found";
        }

        existingCrops.setCropName(updateCrop.getCropName());
        existingCrops.setSoilType(updateCrop.getSoilType());
        existingCrops.setSeason(updateCrop.getSeason());
        existingCrops.setSowingDate(updateCrop.getSowingDate());
        existingCrops.setHarvestDate(updateCrop.getHarvestDate());
        existingCrops.setUser(updateCrop.getUser());

        cropRepo.save(existingCrops);

        return "Crop Update Successfully";
    }

    // Delete Crop
    public String deleteCrop(Long id) {

        Crops existingCrop = cropRepo.findById(id).orElse(null);

        if (existingCrop == null) {
            return "Crop Not Found";
        }

        cropRepo.deleteById(id);

        return "Crop Deleted Successfully";
    }

}
