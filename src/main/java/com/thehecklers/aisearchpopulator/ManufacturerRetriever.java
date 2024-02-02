package com.thehecklers.aisearchpopulator;

import jakarta.annotation.PostConstruct;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class ManufacturerRetriever {
//    @Value("${aircraft.maker.url}")
//    private String aircraftUrl;
//    @Value("${aircraft.maker.application.id}")
//    private String appId;
//    @Value("${aircraft.maker.api.key}")
//    private String apiKey;

    private final AircraftProperties properties;

    private final List<String> manufacturers = new ArrayList<>();

    public ManufacturerRetriever(AircraftProperties properties) {
        this.properties = properties;
    }

    public List<String> getManufacturers() {
        if (manufacturers.isEmpty()) {
            retrieve();
        }
        return manufacturers;
    }

//    @PostConstruct
//    public void retrieve() {
    private Iterable<String> retrieve() {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(properties.makerUrl()).openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", properties.makerApplicationId());
            urlConnection.setRequestProperty("X-Parse-REST-API-Key", properties.makerApiKey());
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                var stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                var data = new JSONObject(stringBuilder.toString());
                data.getJSONArray("results").forEach(o -> {
                    var manufacturer = (JSONObject) o;
                    manufacturers.add(manufacturer.getString("Manufacturer"));
                });
                manufacturers.forEach(System.out::println);
                //System.out.println(data.toString(2));
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return manufacturers;
    }
}
