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

        aircraftMap.put("manufacturer", aircraft.getManufacturer());
        aircraftMap.put("model", aircraft.getModel());
        aircraftMap.put("engineType", aircraft.getEngineType());
        aircraftMap.put("engineThrustLbFt", aircraft.getEngineThrustLbFt());
        aircraftMap.put("maxSpeedKnots", aircraft.getMaxSpeedKnots());
        aircraftMap.put("cruiseSpeedKnots", aircraft.getCruiseSpeedKnots());
        aircraftMap.put("ceilingFt", aircraft.getCeilingFt());
        aircraftMap.put("rateOfClimbFtPerMin", aircraft.getRateOfClimbFtPerMin());
        aircraftMap.put("takeoffGroundRunFt", aircraft.getTakeoffGroundRunFt());
        aircraftMap.put("landingGroundRollFt", aircraft.getLandingGroundRollFt());
        aircraftMap.put("grossWeightLbs", aircraft.getGrossWeightLbs());
        aircraftMap.put("emptyWeightLbs", aircraft.getEmptyWeightLbs());
        aircraftMap.put("lengthFt", aircraft.getLengthFt());
        aircraftMap.put("heightFt", aircraft.getHeightFt());
        aircraftMap.put("wingSpanFt", aircraft.getWingSpanFt());
        aircraftMap.put("rangeNauticalMiles", aircraft.getRangeNauticalMiles());
        aircraftMap.put("takeoffOver50ftFt", aircraft.getTakeoffOver50ftFt());
        aircraftMap.put("landingOver50ftFt", aircraft.getLandingOver50ftFt());

        return aircraftMap;
    }
}
