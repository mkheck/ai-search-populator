package com.thehecklers.aisearchpopulator;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TypeRetriever {
    private final ManufacturerRetriever mfrRetriever;
    private final AircraftProperties properties;

    private final RestClient client;

    public TypeRetriever(ManufacturerRetriever mfrRetriever, AircraftProperties properties) {
        this.mfrRetriever = mfrRetriever;
        this.properties = properties;
        client = RestClient.create(properties.typeUrl());
    }

    public String retrieve() {
        String body = client.get()
                .uri("?manufacturer=Cessna&limit=1")
                .header("X-Api-Key", properties.typeApiKey())
                .retrieve()
                .body(String.class);
        System.out.println(body);

//        System.out.println(client.get()
//                .uri("?manufacturer=Cessna&limit=2")
//                .header("X-Api-Key", apiKey)
//                .retrieve()
//                .body(String.class));

//        mfrRetriever.getManufacturers().forEach(mfr -> {
//            System.out.println("\n\n\n Types of " + mfr + ":");
//
//            var body = client.get()
//                    .uri("?manufacturer={mfr}&limit={limit}", mfr, 2)
//                    .header("X-Api-Key", apiKey)
//                    .retrieve()
//                    .body(String.class);
//
//            System.out.println(body);
//        });

        return body;
    }
}
