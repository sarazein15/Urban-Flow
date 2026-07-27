package com.urbanflow.impactanalysisservice.service.impl;

import com.urbanflow.impactanalysisservice.client.AssetDto;
import com.urbanflow.impactanalysisservice.client.AssetServiceClient;
import com.urbanflow.impactanalysisservice.client.EventServiceClient;
import com.urbanflow.impactanalysisservice.dto.ImpactRequest;
import com.urbanflow.impactanalysisservice.dto.ImpactResponse;
import com.urbanflow.impactanalysisservice.entity.ImpactAnalysisResult;
import com.urbanflow.impactanalysisservice.repository.ImpactAnalysisRepository;
import com.urbanflow.impactanalysisservice.service.ImpactAnalysisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpactAnalysisServiceImpl implements ImpactAnalysisService {

    private final ImpactAnalysisRepository repository;
    private final AssetServiceClient assetServiceClient;
    private final EventServiceClient eventServiceClient;

    public ImpactAnalysisServiceImpl(ImpactAnalysisRepository repository,
                                     AssetServiceClient assetServiceClient,
                                     EventServiceClient eventServiceClient) {
        this.repository = repository;
        this.assetServiceClient = assetServiceClient;
        this.eventServiceClient = eventServiceClient;
    }

    @Override
    public ImpactResponse createImpactAnalysis(Long districtId, ImpactRequest request) {

        List<AssetDto> assets = assetServiceClient.getAssetsByDistrict(districtId);

        int totalAssets = assets.size();

        int affectedAssets = (int) assets.stream()
                .filter(asset -> asset.getStatus() != null &&
                        (asset.getStatus().equalsIgnoreCase("Maintenance")
                                || asset.getStatus().equalsIgnoreCase("Inactive")))
                .count();

        int averageCapacity = (int) assets.stream()
                .filter(asset -> asset.getCapacity() != null)
                .mapToInt(AssetDto::getCapacity)
                .average()
                .orElse(0);

        String eventSeverity = "Low";

        ImpactAnalysisResult result = new ImpactAnalysisResult();

        result.setDistrictId(districtId);
        result.setScenarioId(request.getScenarioId());
        result.setTotalAssets(totalAssets);
        result.setAffectedAssets(affectedAssets);
        result.setAverageCapacity(averageCapacity);
        result.setTrafficChangeLevel(request.getTrafficChangeLevel());

        String capacityImpact = calculateCapacityImpact(averageCapacity);
        String trafficImpact = calculateTrafficImpact(request.getTrafficChangeLevel());
        String riskLevel = calculateRiskLevel(averageCapacity, affectedAssets, totalAssets, eventSeverity);

        result.setCapacityImpact(capacityImpact);
        result.setTrafficImpact(trafficImpact);
        result.setRiskLevel(riskLevel);

        String summary = "Impact analysis completed for district " + districtId + ". "
                + affectedAssets + " out of " + totalAssets
                + " assets are affected. Event severity is " + eventSeverity + ".";

        result.setAnalysisSummary(summary);

        ImpactAnalysisResult saved = repository.save(result);
        return mapToResponse(saved);
    }

    @Override
    public List<ImpactResponse> getImpactAnalysesByDistrict(Long districtId) {
        return repository.findByDistrictId(districtId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ImpactResponse getImpactAnalysisById(Long districtId, Long resultId) {
        ImpactAnalysisResult result = repository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Impact analysis result not found"));

        if (!result.getDistrictId().equals(districtId)) {
            throw new RuntimeException("Impact analysis result does not belong to this district");
        }

        return mapToResponse(result);
    }

    @Override
    public void deleteImpactAnalysis(Long districtId, Long resultId) {
        ImpactAnalysisResult result = repository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Impact analysis result not found"));

        if (!result.getDistrictId().equals(districtId)) {
            throw new RuntimeException("Impact analysis result does not belong to this district");
        }

        repository.delete(result);
    }

    private String calculateCapacityImpact(Integer averageCapacity) {
        if (averageCapacity == null) {
            return "Unknown capacity impact";
        }

        if (averageCapacity >= 500) {
            return "High capacity impact";
        } else if (averageCapacity >= 250) {
            return "Medium capacity impact";
        } else {
            return "Low capacity impact";
        }
    }

    private String calculateTrafficImpact(String trafficChangeLevel) {
        if (trafficChangeLevel == null) {
            return "Unknown traffic impact";
        }

        switch (trafficChangeLevel.toLowerCase()) {
            case "high":
                return "High traffic impact";
            case "moderate":
                return "Moderate traffic impact";
            case "low":
                return "Low traffic impact";
            default:
                return "Unknown traffic impact";
        }
    }

    private String calculateRiskLevel(Integer averageCapacity,
                                      Integer affectedAssets,
                                      Integer totalAssets,
                                      String eventSeverity) {

        if ("High".equalsIgnoreCase(eventSeverity)) {
            return "HIGH";
        }

        if ("Medium".equalsIgnoreCase(eventSeverity)) {
            return "MEDIUM";
        }

        if (averageCapacity == null || affectedAssets == null || totalAssets == null || totalAssets == 0) {
            return "UNKNOWN";
        }

        double affectedRatio = (double) affectedAssets / totalAssets;

        if (averageCapacity >= 500 || affectedRatio >= 0.6) {
            return "HIGH";
        } else if (averageCapacity >= 250 || affectedRatio >= 0.3) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    private ImpactResponse mapToResponse(ImpactAnalysisResult result) {
        ImpactResponse response = new ImpactResponse();

        response.setResultId(result.getResultId());
        response.setDistrictId(result.getDistrictId());
        response.setScenarioId(result.getScenarioId());
        response.setTotalAssets(result.getTotalAssets());
        response.setAffectedAssets(result.getAffectedAssets());
        response.setAverageCapacity(result.getAverageCapacity());
        response.setTrafficChangeLevel(result.getTrafficChangeLevel());
        response.setCapacityImpact(result.getCapacityImpact());
        response.setTrafficImpact(result.getTrafficImpact());
        response.setRiskLevel(result.getRiskLevel());
        response.setAnalysisSummary(result.getAnalysisSummary());
        response.setCreatedAt(result.getCreatedAt());

        return response;
    }
}