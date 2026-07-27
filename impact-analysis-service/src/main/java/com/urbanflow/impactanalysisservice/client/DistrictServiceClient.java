package com.urbanflow.impactanalysisservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DistrictServiceClient {

    private final RestTemplate restTemplate;

    @Value("${district.service.url}")
    private String districtServiceUrl;

    public DistrictServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DistrictDto getDistrictById(Long districtId) {
        String url = districtServiceUrl + "/api/districts/" + districtId;
        return restTemplate.getForObject(url, DistrictDto.class);
    }
}