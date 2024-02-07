package com.thehecklers.aisearchpopulator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AiSearchPopulator {
    private final ManufacturerRetriever manufacturerRetriever;
    private final TypeRetriever typeRetriever;
    private final Filer filer;

    private final VectorFeeder vectorFeeder;

    public AiSearchPopulator(ManufacturerRetriever manufacturerRetriever, TypeRetriever typeRetriever, Filer filer, VectorFeeder vectorFeeder) {
        this.manufacturerRetriever = manufacturerRetriever;
        this.typeRetriever = typeRetriever;
        this.filer = filer;
        this.vectorFeeder = vectorFeeder;
    }

    @PostConstruct
    public void populate() {
        manufacturerRetriever.getManufacturers()
                .forEach(mfr -> {
                    // Thirty is the max for this API
                    var types = typeRetriever.retrieve(mfr, 30);
                    if (types.iterator().hasNext()) {
                        filer.writeToFile(mfr + ".txt", types);
                        vectorFeeder.store(types);
                    }
                });
    }
}
