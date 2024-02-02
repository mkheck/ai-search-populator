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
    @Value("${aircraft.url}")
    private String aircraftUrl;
    @Value("${aircraft.application.id}")
    private String appId;
    @Value("${aircraft.api.key}")
    private String apiKey;

    private final RestClient client = RestClient.create();

    private final List<String> manufacturers = new ArrayList<>();

    public List<String> getManufacturers() {
        return manufacturers;
    }

    @PostConstruct
    public void retrieve() {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(aircraftUrl).openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", appId);
            urlConnection.setRequestProperty("X-Parse-REST-API-Key", apiKey);
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
    }
}
