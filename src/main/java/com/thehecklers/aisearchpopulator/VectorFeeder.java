package com.thehecklers.aisearchpopulator;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class VectorFeeder {
    private final VectorStore vectorStore;

    public VectorFeeder(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public void store(Iterable<Aircraft> aircraft) {
        var aircraftMap = new HashMap<String, Object>();
        var documents = new ArrayList<Document>();

        aircraft.forEach(a -> {
            aircraftMap.clear();

            aircraftMap.put("manufacturer", a.manufacturer());
            aircraftMap.put("model", a.model());
            aircraftMap.put("engine_type", a.engine_type());
            aircraftMap.put("engine_thrust_lb_ft", a.engine_thrust_lb_ft());
            aircraftMap.put("max_speed_knots", a.max_speed_knots());
            aircraftMap.put("cruise_speed_knots", a.cruise_speed_knots());
            aircraftMap.put("ceiling_ft", a.ceiling_ft());
            aircraftMap.put("rate_of_climb_ft_per_min", a.rate_of_climb_ft_per_min());
            aircraftMap.put("takeoff_ground_run_ft", a.takeoff_ground_run_ft());
            aircraftMap.put("landing_ground_roll_ft", a.landing_ground_roll_ft());
            aircraftMap.put("gross_weight_lbs", a.gross_weight_lbs());
            aircraftMap.put("empty_weight_lbs", a.empty_weight_lbs());
            aircraftMap.put("length_ft", a.length_ft());
            aircraftMap.put("height_ft", a.height_ft());
            aircraftMap.put("wing_span_ft", a.wing_span_ft());
            aircraftMap.put("range_nautical_miles", a.range_nautical_miles());
            aircraftMap.put("takeoff_over_50ft_ft", a.takeoff_over_50ft_ft());
            aircraftMap.put("landing_over_50ft_ft", a.landing_over_50ft_ft());

            documents.add(new Document(a.toString(), aircraftMap));
//            documents.add(new Document(UUID.randomUUID().toString(), a.toString(), aircraftMap));

            System.out.println("Stored document: " + documents.getLast().toString());
        });

        if (!documents.isEmpty()) {
            System.out.println("Storing " + documents.size() + " documents");
            //vectorStore.add(List.copyOf(documents));
            vectorStore.add(documents);
        }
    }
}
