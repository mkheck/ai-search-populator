package com.thehecklers.aisearchpopulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class AiSearchPopulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiSearchPopulatorApplication.class, args);
	}

}
