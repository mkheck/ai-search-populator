package com.thehecklers.aisearchpopulator;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TypeRetriever {
    @Value("${aircraft.type.url}")
    private String typeUrl;
    @Value("${aircraft.type.api.key}")
    private String apiKey;

    private final ManufacturerRetriever mfrRetriever;

    public TypeRetriever(ManufacturerRetriever mfrRetriever) {
        this.mfrRetriever = mfrRetriever;
    }

    @PostConstruct
    public void retrieve() {
        System.out.println("\n\n\n Types of " + mfrRetriever.getManufacturers().getFirst() + ":");

        RestClient client = RestClient.create(typeUrl);

        System.out.println(client.get()
                .uri("?manufacturer={mfr}&limit=30", mfrRetriever.getManufacturers().getFirst())
                .header("X-Api-Key", apiKey)
                .retrieve()
                .body(String.class));
    }
}
