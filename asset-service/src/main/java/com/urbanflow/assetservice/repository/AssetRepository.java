package com.urbanflow.assetservice.repository;

import com.urbanflow.assetservice.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByDistrictId(Long districtId);
}