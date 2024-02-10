package com.thehecklers.aisearchpopulator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = {Filer.class})
class FilerTest {
    @Autowired
    private Filer filer;

    @Test
    void writeToFile() {
        Aircraft expectedAircraft1 = new Aircraft(
                "Cessna Aircraft Company",
                "Citation Longitude",
                "Jet",
                7665,
                560F,
                "483",
                45000,
                2550,
                4810,
                2595,
                39500,
                23600,
                73.167F,
                19.417F,
                68.917F,
                "3500",
                null,
                null);

        Aircraft expectedAircraft2 = new Aircraft(
                "Cessna Aircraft Company",
                "750 Citation X",
                "Jet",
                6400,
                613F,
                "511 kts",
                51000,
                3720,
                null,
                null,
                35700,
                21400,
                72.167F,
                18.75F,
                63.75F,
                "3250+",
                5710,
                3820);

        filer.writeToFile("test.txt", List.of(expectedAircraft1, expectedAircraft2));

        assertTrue(Files.exists(Path.of("test.txt")));

        // // Read the file back into a String
        // String fileContent = new String(Files.readAllBytes(Paths.get("test.txt")));

        // // Prepare the expected output
        // String expectedOutput = expectedAircraft1.toString() + "\n" + expectedAircraft2.toString() + "\n";

        // // Assert that the file content matches the expected output
        // assertEquals(expectedOutput, fileContent);
    }
}