package com.thehecklers.aisearchpopulator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AiSearchPopulator {
    private final ManufacturerRetriever manufacturerRetriever;
    private final TypeRetriever typeRetriever;
    private final Filer filer;

    public AiSearchPopulator(ManufacturerRetriever manufacturerRetriever, TypeRetriever typeRetriever, Filer filer) {
        this.manufacturerRetriever = manufacturerRetriever;
        this.typeRetriever = typeRetriever;
        this.filer = filer;
    }

    @PostConstruct
    public void populate() {
        manufacturerRetriever.getManufacturers()
                .forEach(mfr -> {
                    var types = typeRetriever.retrieve(mfr, 2);
                    if (types.iterator().hasNext()) {
                        filer.writeToFile(mfr + ".txt", types);
                    }
                });
    }
}
