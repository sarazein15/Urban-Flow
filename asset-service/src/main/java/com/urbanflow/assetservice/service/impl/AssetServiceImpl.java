package com.urbanflow.assetservice.service.impl;

import com.urbanflow.assetservice.dto.AssetRequest;
import com.urbanflow.assetservice.dto.AssetResponse;
import com.urbanflow.assetservice.entity.Asset;
import com.urbanflow.assetservice.repository.AssetRepository;
import com.urbanflow.assetservice.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public AssetResponse createAsset(Long districtId, AssetRequest request) {
        Asset asset = new Asset();
        asset.setDistrictId(districtId);
        asset.setZoneId(request.getZoneId());
        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setLocation(request.getLocation());
        asset.setCapacity(request.getCapacity());
        asset.setStatus(request.getStatus());

        Asset saved = assetRepository.save(asset);
        return mapToResponse(saved);
    }

    @Override
    public List<AssetResponse> getAssetsByDistrict(Long districtId) {
        return assetRepository.findByDistrictId(districtId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AssetResponse updateAsset(Long districtId, Long assetId, AssetRequest request) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        if (!asset.getDistrictId().equals(districtId)) {
            throw new RuntimeException("Asset does not belong to this district");
        }

        asset.setZoneId(request.getZoneId());
        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setLocation(request.getLocation());
        asset.setCapacity(request.getCapacity());
        asset.setStatus(request.getStatus());

        Asset updated = assetRepository.save(asset);
        return mapToResponse(updated);
    }

    @Override
    public void deleteAsset(Long districtId, Long assetId) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        if (!asset.getDistrictId().equals(districtId)) {
            throw new RuntimeException("Asset does not belong to this district");
        }

        assetRepository.delete(asset);
    }

    private AssetResponse mapToResponse(Asset asset) {
        AssetResponse response = new AssetResponse();
        response.setAssetId(asset.getAssetId());
        response.setDistrictId(asset.getDistrictId());
        response.setZoneId(asset.getZoneId());
        response.setAssetName(asset.getAssetName());
        response.setAssetType(asset.getAssetType());
        response.setLocation(asset.getLocation());
        response.setCapacity(asset.getCapacity());
        response.setStatus(asset.getStatus());
        return response;
    }
}