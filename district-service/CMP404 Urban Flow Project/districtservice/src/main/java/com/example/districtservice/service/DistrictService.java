package com.example.districtservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.districtservice.entity.District;
import com.example.districtservice.repository.DistrictRepository;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    public District getDistrictById(Long id) {
        return districtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("District not found"));
    }

    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }

	public District updateDistrict(Long id, District updatedDistrict) {
		// TODO Auto-generated method stub
		return null;
	}
}