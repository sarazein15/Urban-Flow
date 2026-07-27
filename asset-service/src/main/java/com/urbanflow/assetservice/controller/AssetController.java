package com.urbanflow.assetservice.controller;

import com.urbanflow.assetservice.dto.AssetRequest;
import com.urbanflow.assetservice.dto.AssetResponse;
import com.urbanflow.assetservice.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts/{districtId}/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public ResponseEntity<AssetResponse> createAsset(
            @PathVariable Long districtId,
            @Valid @RequestBody AssetRequest request) {
        return new ResponseEntity<>(assetService.createAsset(districtId, request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssetResponse>> getAssetsByDistrict(@PathVariable Long districtId) {
        return ResponseEntity.ok(assetService.getAssetsByDistrict(districtId));
    }

    @PutMapping("/{assetId}")
    public ResponseEntity<AssetResponse> updateAsset(
            @PathVariable Long districtId,
            @PathVariable Long assetId,
            @Valid @RequestBody AssetRequest request) {
        return ResponseEntity.ok(assetService.updateAsset(districtId, assetId, request));
    }

    @DeleteMapping("/{assetId}")
    public ResponseEntity<String> deleteAsset(
            @PathVariable Long districtId,
            @PathVariable Long assetId) {
        assetService.deleteAsset(districtId, assetId);
        return ResponseEntity.ok("Asset deleted successfully");
    }
}