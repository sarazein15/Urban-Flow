package com.urbanflow.assetservice.service;

import com.urbanflow.assetservice.dto.AssetRequest;
import com.urbanflow.assetservice.dto.AssetResponse;

import java.util.List;

public interface AssetService {
    AssetResponse createAsset(Long districtId, AssetRequest request);
    List<AssetResponse> getAssetsByDistrict(Long districtId);
    AssetResponse updateAsset(Long districtId, Long assetId, AssetRequest request);
    void deleteAsset(Long districtId, Long assetId);
}