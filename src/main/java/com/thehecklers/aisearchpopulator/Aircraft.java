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
) {
        // Clean up the many, many nulls inbound on which VectorStore chokes
        public Aircraft(String manufacturer, 
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
                        String landing_over_50ft_ft) {
                this.manufacturer = manufacturer;
                this.model = model;
                this.engine_type = null == engine_type ? "UNSPECIFIED" : engine_type;
                this.engine_thrust_lb_ft = null == engine_thrust_lb_ft ? "0" : engine_thrust_lb_ft;
                this.max_speed_knots = null == max_speed_knots ? "0" : max_speed_knots;
                this.cruise_speed_knots = null == cruise_speed_knots ? "0" : cruise_speed_knots;
                this.ceiling_ft = null == ceiling_ft ? "0" : ceiling_ft;
                this.rate_of_climb_ft_per_min = null == rate_of_climb_ft_per_min ? "0" : rate_of_climb_ft_per_min;
                this.takeoff_ground_run_ft = null == takeoff_ground_run_ft ? "0" : takeoff_ground_run_ft;
                this.landing_ground_roll_ft = null == landing_ground_roll_ft ? "0" : landing_ground_roll_ft;
                this.gross_weight_lbs = null == gross_weight_lbs ? "0" : gross_weight_lbs;
                this.empty_weight_lbs = null == empty_weight_lbs ? "0" : empty_weight_lbs;
                this.length_ft = null == length_ft ? "0" : length_ft;
                this.height_ft = null == height_ft ? "0" : height_ft;
                this.wing_span_ft = null == wing_span_ft ? "0" : wing_span_ft;
                this.range_nautical_miles = null == range_nautical_miles ? "0" : range_nautical_miles;
                this.takeoff_over_50ft_ft = null == takeoff_over_50ft_ft ? "0" : takeoff_over_50ft_ft;
                this.landing_over_50ft_ft = null == landing_over_50ft_ft ? "0" : landing_over_50ft_ft;
        }
}