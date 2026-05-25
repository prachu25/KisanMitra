package com.backend.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.DiseaseReport;
import com.backend.backend.repository.DiseaseReportRepository;

@Service
public class DiseaseReportService {

    @Autowired
    private DiseaseReportRepository disRepo;

    // Get All Reports
    public List<DiseaseReport> getAllReports() {
        return disRepo.findAll();
    }

    // Add Disease Report
    public String addReport(DiseaseReport report) {

        // Image Validation
        if (report.getImageUrl() == null || report.getImageUrl().isEmpty()) {
            return "Image URL is Required";
        }

        // Description Validation
        if (report.getDescription() == null || report.getDescription().isEmpty()) {
            return "Description is Required";
        }

        // Default Status
        report.setStatus("Pending");

        disRepo.save(report);

        return "Disease Report Added Sucessfully";
    }

    // Get Report By Id
    public DiseaseReport getReportById(Long id) {
        return disRepo.findById(id).orElse(null);
    }

    // Get Report By User ID
    public List<DiseaseReport> getreportByUserId(Long userId) {
        return disRepo.findByUser_Id(userId);
    }

    // Update Disease Report
    public String updateDiseaseReport(Long id, DiseaseReport updateReport) {

        DiseaseReport existingReport = disRepo.findById(id).orElse(null);

        if (existingReport == null) {
            return "Disease Report Not Found";
        }

        existingReport.setImageUrl(updateReport.getImageUrl());
        existingReport.setDescription(updateReport.getDescription());
        existingReport.setStatus(updateReport.getStatus());
        existingReport.setUser(updateReport.getUser());

        disRepo.save(existingReport);

        return "DIsease Report  Update Successfully";
    }

    // Delete Disease Report
    public String deleteReport(Long id) {

        DiseaseReport exisitingReport = disRepo.findById(id).orElse(null);

        if (exisitingReport == null) {
            return "Disease Report Not Found";
        }

        disRepo.deleteById(id);

        return "Disease Report Deleted successfully";
    }

}
