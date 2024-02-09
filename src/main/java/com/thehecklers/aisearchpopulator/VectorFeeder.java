package com.thehecklers.aisearchpopulator;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class VectorFeeder {
    private final VectorStore vectorStore;

    public VectorFeeder(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public void store(Iterable<Aircraft> aircraft) {
        var documents = new ArrayList<Document>();

        aircraft.forEach(a -> documents.add(new Document(a.toString(), createMapFromAircraft(a))));

        if (!documents.isEmpty()) {
            System.out.println("Storing " + documents.size() + " documents");
            vectorStore.add(documents);
        }
    }

    public Map<String, Object> createMapFromAircraft(Aircraft aircraft) {
        var aircraftMap = new HashMap<String, Object>();

        aircraftMap.put("manufacturer", aircraft.manufacturer());
        aircraftMap.put("model", aircraft.model());
        aircraftMap.put("engineType", aircraft.engineType());
        aircraftMap.put("engineThrustLbFt", aircraft.engineThrustLbFt());
        aircraftMap.put("maxSpeedKnots", aircraft.maxSpeedKnots());
        aircraftMap.put("cruiseSpeedKnots", aircraft.cruiseSpeedKnots());
        aircraftMap.put("ceilingFt", aircraft.ceilingFt());
        aircraftMap.put("rateOfClimbFtPerMin", aircraft.rateOfClimbFtPerMin());
        aircraftMap.put("takeoffGroundRunFt", aircraft.takeoffGroundRunFt());
        aircraftMap.put("landingGroundRollFt", aircraft.landingGroundRollFt());
        aircraftMap.put("grossWeightLbs", aircraft.grossWeightLbs());
        aircraftMap.put("emptyWeightLbs", aircraft.emptyWeightLbs());
        aircraftMap.put("lengthFt", aircraft.lengthFt());
        aircraftMap.put("heightFt", aircraft.heightFt());
        aircraftMap.put("wingSpanFt", aircraft.wingSpanFt());
        aircraftMap.put("rangeNauticalMiles", aircraft.rangeNauticalMiles());
        aircraftMap.put("takeoffOver50ftFt", aircraft.takeoffOver50ftFt());
        aircraftMap.put("landingOver50ftFt", aircraft.landingOver50ftFt());

        return aircraftMap;
    }
}
