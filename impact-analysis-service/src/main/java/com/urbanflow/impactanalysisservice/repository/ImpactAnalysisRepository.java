package com.urbanflow.impactanalysisservice.repository;

import com.urbanflow.impactanalysisservice.entity.ImpactAnalysisResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImpactAnalysisRepository extends JpaRepository<ImpactAnalysisResult, Long> {
    List<ImpactAnalysisResult> findByDistrictId(Long districtId);
}