package com.thehecklers.aisearchpopulator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import jakarta.annotation.PostConstruct;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerRetriever {
    @Value("${aircraft.url}")
    private String aircraftUrl;

    @Value("${aircraft.application.id}")
    private String appId;

    @Value("${aircraft.api.key}")
    private String apiKey;

    @PostConstruct
    public void retrieve() {
        try {
            URL url = new URL(aircraftUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("X-Parse-Application-Id", appId); // This is your app's application id
            urlConnection.setRequestProperty("X-Parse-REST-API-Key", apiKey);
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                JSONObject data = new JSONObject(stringBuilder.toString()); // Here you have the data that you need
                System.out.println(data.toString(2));
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
