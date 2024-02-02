package com.thehecklers.aisearchpopulator;

public record Aircraft(
        String manufacturer,
        String model,
        String engine_type,
        String engine_thrust_lb_ft,
        String max_speed_knots,
        String cruise_speed_knots,
        String ceiling_ft,
        String rate_of_climb_ft_per_min,
        String takeoff_ground_run_ft,
        String landing_ground_roll_ft,
        String gross_weight_lbs,
        String empty_weight_lbs,
        String length_ft,
        String height_ft,
        String wing_span_ft,
        String range_nautical_miles,
        String takeoff_over_50ft_ft,
        String landing_over_50ft_ft
) {}