package com.urbanflow.impactanalysisservice.controller;

import com.urbanflow.impactanalysisservice.dto.ImpactRequest;
import com.urbanflow.impactanalysisservice.dto.ImpactResponse;
import com.urbanflow.impactanalysisservice.service.ImpactAnalysisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts/{districtId}/impact-analysis")
public class ImpactAnalysisController {

    private final ImpactAnalysisService impactAnalysisService;

    public ImpactAnalysisController(ImpactAnalysisService impactAnalysisService) {
        this.impactAnalysisService = impactAnalysisService;
    }

    @PostMapping
    public ResponseEntity<ImpactResponse> createImpactAnalysis(
            @PathVariable Long districtId,
            @RequestBody ImpactRequest request) {

        ImpactResponse response = impactAnalysisService.createImpactAnalysis(districtId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ImpactResponse>> getImpactAnalysesByDistrict(
            @PathVariable Long districtId) {

        return ResponseEntity.ok(impactAnalysisService.getImpactAnalysesByDistrict(districtId));
    }

    @GetMapping("/{resultId}")
    public ResponseEntity<ImpactResponse> getImpactAnalysisById(
            @PathVariable Long districtId,
            @PathVariable Long resultId) {

        return ResponseEntity.ok(impactAnalysisService.getImpactAnalysisById(districtId, resultId));
    }

    @DeleteMapping("/{resultId}")
    public ResponseEntity<String> deleteImpactAnalysis(
            @PathVariable Long districtId,
            @PathVariable Long resultId) {

        impactAnalysisService.deleteImpactAnalysis(districtId, resultId);
        return ResponseEntity.ok("Impact analysis result deleted successfully");
    }
}