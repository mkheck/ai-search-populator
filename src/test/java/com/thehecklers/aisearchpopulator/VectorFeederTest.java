package com.thehecklers.aisearchpopulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@WebMvcTest(value = {VectorFeeder.class})
class VectorFeederTest {
    @MockBean
    private VectorStore vectorStore;

    @Autowired
    private VectorFeeder vectorFeeder;

    private Aircraft expectedAircraft1, expectedAircraft2;

    private List<Document> documentList;

    @BeforeEach
    void setUp() {
        expectedAircraft1 = new Aircraft(
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
                "0",
                "0");

        expectedAircraft2 = new Aircraft(
                "Cessna Aircraft Company",
                "750 Citation X",
                "Jet",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);

        documentList =
                List.of(
                        new Document(expectedAircraft1.toString(), vectorFeeder.createMapFromAircraft(expectedAircraft1)),
                        new Document(expectedAircraft2.toString(), vectorFeeder.createMapFromAircraft(expectedAircraft2)));
        when(vectorStore.similaritySearch("Cessna Aircraft Company")).thenReturn(documentList);
    }

    @Test
    void store() {
        vectorFeeder.store(List.of(expectedAircraft1, expectedAircraft2));

        documentList.forEach(System.out::println);

        assertEquals(vectorStore.similaritySearch("Cessna Aircraft Company"), documentList);
    }
}