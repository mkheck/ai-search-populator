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
//        retrieve();
    }

//    @PostConstruct
//    public void init() {
//        retrieve();
//    }

    public String retrieve() {
        RestClient client = RestClient.create(typeUrl);

        String body = client.get()
                .uri("?manufacturer=Cessna&limit=1")
                .header("X-Api-Key", apiKey)
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
