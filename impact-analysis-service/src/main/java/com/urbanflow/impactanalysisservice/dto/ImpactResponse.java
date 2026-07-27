package com.urbanflow.impactanalysisservice.dto;

import java.time.LocalDateTime;

public class ImpactResponse {

    private Long resultId;
    private Long districtId;
    private Long scenarioId;
    private Integer totalAssets;
    private Integer affectedAssets;
    private Integer averageCapacity;
    private String trafficChangeLevel;
    private String capacityImpact;
    private String trafficImpact;
    private String riskLevel;
    private String analysisSummary;
    private LocalDateTime createdAt;

    public ImpactResponse() {
    }

    public Long getResultId() { return resultId; }
    public void setResultId(Long resultId) { this.resultId = resultId; }

    public Long getDistrictId() { return districtId; }
    public void setDistrictId(Long districtId) { this.districtId = districtId; }

    public Long getScenarioId() { return scenarioId; }
    public void setScenarioId(Long scenarioId) { this.scenarioId = scenarioId; }

    public Integer getTotalAssets() { return totalAssets; }
    public void setTotalAssets(Integer totalAssets) { this.totalAssets = totalAssets; }

    public Integer getAffectedAssets() { return affectedAssets; }
    public void setAffectedAssets(Integer affectedAssets) { this.affectedAssets = affectedAssets; }

    public Integer getAverageCapacity() { return averageCapacity; }
    public void setAverageCapacity(Integer averageCapacity) { this.averageCapacity = averageCapacity; }

    public String getTrafficChangeLevel() { return trafficChangeLevel; }
    public void setTrafficChangeLevel(String trafficChangeLevel) { this.trafficChangeLevel = trafficChangeLevel; }

    public String getCapacityImpact() { return capacityImpact; }
    public void setCapacityImpact(String capacityImpact) { this.capacityImpact = capacityImpact; }

    public String getTrafficImpact() { return trafficImpact; }
    public void setTrafficImpact(String trafficImpact) { this.trafficImpact = trafficImpact; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public String getAnalysisSummary() { return analysisSummary; }
    public void setAnalysisSummary(String analysisSummary) { this.analysisSummary = analysisSummary; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}