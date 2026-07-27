package com.urbanflow.impactanalysisservice.service;

import com.urbanflow.impactanalysisservice.dto.ImpactRequest;
import com.urbanflow.impactanalysisservice.dto.ImpactResponse;

import java.util.List;

public interface ImpactAnalysisService {

    ImpactResponse createImpactAnalysis(Long districtId, ImpactRequest request);

    List<ImpactResponse> getImpactAnalysesByDistrict(Long districtId);

    ImpactResponse getImpactAnalysisById(Long districtId, Long resultId);

    void deleteImpactAnalysis(Long districtId, Long resultId);
}