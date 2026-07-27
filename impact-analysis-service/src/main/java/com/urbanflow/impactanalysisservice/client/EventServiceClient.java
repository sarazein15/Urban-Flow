package com.urbanflow.impactanalysisservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class EventServiceClient {

    private final WebClient webClient;

    public EventServiceClient(@Value("${event.service.url}") String eventServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(eventServiceUrl)
                .build();
    }

    public EventDto getEventById(Long districtId, Long eventId) {
        return webClient.get()
                .uri("/api/districts/{districtId}/events/{eventId}", districtId, eventId)
                .retrieve()
                .bodyToMono(EventDto.class)
                .block();
    }
}