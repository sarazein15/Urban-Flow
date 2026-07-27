package com.example.districtservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Component
public class AssetClient {

    private final WebClient webClient;

    public AssetClient(@Value("${asset.service.url}") String assetServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(assetServiceUrl)
                .build();
    }

    public List<AssetDto> getAssetsByDistrict(Long districtId) {
        AssetDto[] assets = webClient.get()
                .uri("/api/districts/{districtId}/assets", districtId)
                .retrieve()
                .bodyToMono(AssetDto[].class)
                .block();

        return Arrays.asList(assets);
    }
}