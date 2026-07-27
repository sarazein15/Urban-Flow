package com.urbanflow.impactanalysisservice.dto;

public class ImpactRequest {

    private Long scenarioId;
    private Integer totalAssets;
    private Integer affectedAssets;
    private Integer averageCapacity;
    private String trafficChangeLevel;

    public ImpactRequest() {
    }

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
}