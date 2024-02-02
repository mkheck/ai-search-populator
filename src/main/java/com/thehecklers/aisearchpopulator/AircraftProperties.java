package com.thehecklers.aisearchpopulator;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("aircraft")
public record AircraftProperties(String makerUrl, String makerApplicationId, String makerApiKey,
                                 String typeUrl, String typeApiKey) {}
