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

import com.backend.backend.entity.DiseaseReport;
import com.backend.backend.service.DiseaseReportService;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseReportController {

    @Autowired
    private DiseaseReportService disServ;

    // Get All Reports
    @GetMapping("/all")
    public List<DiseaseReport> getAllReports() {
        return disServ.getAllReports();
    }

    // Add Disease Reports
    @PostMapping("/add-report")
    public String addReport(@RequestBody DiseaseReport report) {
        return disServ.addReport(report);
    }

    // Get Report By Id
    @GetMapping("/report/{id}")
    public DiseaseReport getReportById(@PathVariable Long id) {
        return disServ.getReportById(id);
    }

    // Get Report By UserID
    @GetMapping("/user-report/{userId}")
    public List<DiseaseReport> findByUserReport(@PathVariable Long userId) {
        return disServ.getreportByUserId(userId);
    }

    // Update Disease Report
    @PutMapping("/update-report/{id}")
    public String updateReport(@PathVariable Long id, @RequestBody DiseaseReport report) {

        return disServ.updateDiseaseReport(id, report);
    }

    // Delete Disease Report
    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable Long id) {

        return disServ.deleteReport(id);
    }

}
