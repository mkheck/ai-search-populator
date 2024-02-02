package com.thehecklers.aisearchpopulator;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class TypeRetriever {
    private final AircraftProperties properties;

    private final RestClient client;

    public TypeRetriever(AircraftProperties properties) {
        this.properties = properties;
        client = RestClient.create(properties.typeUrl());
    }

    public Iterable<Aircraft> retrieve(String manufacturer, int limit) {
        List<Aircraft> aircraftList = client.get()
                .uri("?manufacturer={manufacturer}&limit={limit}", manufacturer, limit)
                .header("X-Api-Key", properties.typeApiKey())
                .retrieve()
                .body(new ParameterizedTypeReference<List<Aircraft>>() {
                });

        //System.out.println(aircraftList);

        return aircraftList;
    }
}
