package com.example.districtservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.districtservice.entity.District;
import com.example.districtservice.entity.Zone;
import com.example.districtservice.repository.DistrictRepository;
import com.example.districtservice.repository.ZoneRepository;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private DistrictRepository districtRepository;

    public Zone createZone(Zone zone, Long districtId) {
        District district = districtRepository.findById(districtId)
                .orElseThrow(() -> new RuntimeException("District not found"));

        zone.setDistrict(district);
        return zoneRepository.save(zone);
    }

    public void deleteZone(Long zoneId) {
        Zone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
        zoneRepository.delete(zone);
    }
}