package com.thehecklers.aisearchpopulator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AiSearchPopulator {
    private final ManufacturerRetriever manufacturerRetriever;
    private final TypeRetriever typeRetriever;

    public AiSearchPopulator(ManufacturerRetriever manufacturerRetriever, TypeRetriever typeRetriever) {
        this.manufacturerRetriever = manufacturerRetriever;
        this.typeRetriever = typeRetriever;
    }

    @PostConstruct
    public void populate() {
        manufacturerRetriever.getManufacturers()
                .forEach(mfr -> typeRetriever.retrieve(mfr, 2)
                                .forEach(System.out::println));
    }
}
