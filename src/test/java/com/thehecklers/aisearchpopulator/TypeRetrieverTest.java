package com.thehecklers.aisearchpopulator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = {TypeRetriever.class, AircraftProperties.class})
class TypeRetrieverTest {
    @MockBean
    private ManufacturerRetriever manufacturerRetriever;

    @Autowired
    private TypeRetriever typeRetriever;

    @Test
    void retrieve() {
        Aircraft expectedAircraft1 = new Aircraft(
                "Cessna Aircraft Company",
                "Citation Longitude",
                "Jet",
                "7665",
                "560",
                "483",
                "45000",
                "2550",
                "4810",
                "2595",
                "39500",
                "23600",
                "73.167",
                "19.417",
                "68.917",
                "3500",
                null,
                null
        );

        Aircraft expectedAircraft2 = new Aircraft(
                "Cessna Aircraft Company",
                "750 Citation X",
                "Jet",
                "6400",
                "613",
                "511",
                "51000",
                "3720",
                null,
                null,
                "35700",
                "21400",
                "72.167",
                "18.75",
                "63.75",
                "3250",
                "5710",
                "3820"
        );

        Iterable<Aircraft> actualAircraft = typeRetriever.retrieve("Cessna", 2);
        assertEquals(List.of(expectedAircraft1, expectedAircraft2), actualAircraft);
    }
}