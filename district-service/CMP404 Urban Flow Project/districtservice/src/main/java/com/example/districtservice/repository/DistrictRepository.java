package com.example.districtservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.districtservice.entity.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
}