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
        aircraftMap.put("engine_type", aircraft.engine_type());
        aircraftMap.put("engine_thrust_lb_ft", aircraft.engine_thrust_lb_ft());
        aircraftMap.put("max_speed_knots", aircraft.max_speed_knots());
        aircraftMap.put("cruise_speed_knots", aircraft.cruise_speed_knots());
        aircraftMap.put("ceiling_ft", aircraft.ceiling_ft());
        aircraftMap.put("rate_of_climb_ft_per_min", aircraft.rate_of_climb_ft_per_min());
        aircraftMap.put("takeoff_ground_run_ft", aircraft.takeoff_ground_run_ft());
        aircraftMap.put("landing_ground_roll_ft", aircraft.landing_ground_roll_ft());
        aircraftMap.put("gross_weight_lbs", aircraft.gross_weight_lbs());
        aircraftMap.put("empty_weight_lbs", aircraft.empty_weight_lbs());
        aircraftMap.put("length_ft", aircraft.length_ft());
        aircraftMap.put("height_ft", aircraft.height_ft());
        aircraftMap.put("wing_span_ft", aircraft.wing_span_ft());
        aircraftMap.put("range_nautical_miles", aircraft.range_nautical_miles());
        aircraftMap.put("takeoff_over_50ft_ft", aircraft.takeoff_over_50ft_ft());
        aircraftMap.put("landing_over_50ft_ft", aircraft.landing_over_50ft_ft());

        return aircraftMap;
    }
}
