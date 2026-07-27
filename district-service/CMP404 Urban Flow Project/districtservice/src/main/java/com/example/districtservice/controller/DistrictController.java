package com.example.districtservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.districtservice.entity.District;
import com.example.districtservice.entity.Zone;
import com.example.districtservice.service.DistrictService;
import com.example.districtservice.service.ZoneService;
import com.example.districtservice.client.AssetClient;
import com.example.districtservice.client.AssetDto;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private AssetClient assetClient;

    @PostMapping
    public District createDistrict(@RequestBody District district) {
        return districtService.createDistrict(district);
    }

    @GetMapping
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }

    @GetMapping("/{id}")
    public District getDistrictById(@PathVariable Long id) {
        return districtService.getDistrictById(id);
    }

    @PutMapping("/{id}")
    public District updateDistrict(@PathVariable Long id, @RequestBody District updatedDistrict) {
        return districtService.updateDistrict(id, updatedDistrict);
    }

    @DeleteMapping("/{id}")
    public void deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
    }

    @PostMapping("/{id}/zones")
    public Zone createZone(@PathVariable Long id, @RequestBody Zone zone) {
        return zoneService.createZone(zone, id);
    }

    @GetMapping("/{districtId}/assets")
    public List<AssetDto> getAssetsForDistrict(@PathVariable Long districtId) {
        return assetClient.getAssetsByDistrict(districtId);
    }
}