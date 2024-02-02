package com.thehecklers.aisearchpopulator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = {TypeRetriever.class, AircraftProperties.class})
class TypeRetrieverTest {
    @MockBean
    private ManufacturerRetriever manufacturerRetriever;

    @Autowired
    private TypeRetriever typeRetriever;

    @Test
    void retrieve() {
        String expectedResponse = "[{\"manufacturer\": \"Cessna Aircraft Company\", \"model\": \"Citation Longitude\", \"engine_type\": \"Jet\", \"engine_thrust_lb_ft\": \"7665\", \"max_speed_knots\": \"560\", \"cruise_speed_knots\": \"483\", \"ceiling_ft\": \"45000\", \"rate_of_climb_ft_per_min\": \"2550\", \"takeoff_ground_run_ft\": \"4810\", \"landing_ground_roll_ft\": \"2595\", \"gross_weight_lbs\": \"39500\", \"empty_weight_lbs\": \"23600\", \"length_ft\": \"73.167\", \"height_ft\": \"19.417\", \"wing_span_ft\": \"68.917\", \"range_nautical_miles\": \"3500\"}]";
        String actualResponse = typeRetriever.retrieve();
        assertEquals(expectedResponse, actualResponse);
    }
}