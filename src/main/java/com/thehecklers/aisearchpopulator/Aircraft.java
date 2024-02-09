package com.thehecklers.aisearchpopulator;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Aircraft(
        String manufacturer,
        String model,
        String engineType,
        String engineThrustLbFt,
        String maxSpeedKnots,
        String cruiseSpeedKnots,
        String ceilingFt,
        String rateOfClimbFtPerMin,
        String takeoffGroundRunFt,
        String landingGroundRollFt,
        String grossWeightLbs,
        String emptyWeightLbs,
        String lengthFt,
        String heightFt,
        String wingSpanFt,
        String rangeNauticalMiles,
        String takeoffOver50ftFt,
        String landingOver50ftFt
) {
        // Clean up the many, many nulls inbound on which VectorStore chokes
        public Aircraft(String manufacturer, 
                        String model,
                        @JsonProperty("engine_type")
                        String engineType,
                        @JsonProperty("engine_thrust_lb_ft")
                        String engineThrustLbFt,
                        @JsonProperty("max_speed_knots")
                        String maxSpeedKnots,
                        @JsonProperty("cruise_speed_knots")
                        String cruiseSpeedKnots,
                        @JsonProperty("ceiling_ft")
                        String ceilingFt,
                        @JsonProperty("rate_of_climb_ft_per_min")
                        String rateOfClimbFtPerMin,
                        @JsonProperty("takeoff_ground_run_ft")
                        String takeoffGroundRunFt,
                        @JsonProperty("landing_ground_roll_ft")
                        String landingGroundRollFt,
                        @JsonProperty("gross_weight_lbs")
                        String grossWeightLbs,
                        @JsonProperty("empty_weight_lbs")
                        String emptyWeightLbs,
                        @JsonProperty("length_ft")
                        String lengthFt,
                        @JsonProperty("height_ft")
                        String heightFt,
                        @JsonProperty("wing_span_ft")
                        String wingSpanFt,
                        @JsonProperty("range_nautical_miles")
                        String rangeNauticalMiles,
                        @JsonProperty("takeoff_over_50ft_ft")
                        String takeoffOver50ftFt,
                        @JsonProperty("landing_over_50ft_ft")
                        String landingOver50ftFt) {
                this.manufacturer = manufacturer;
                this.model = model;
                this.engineType = null == engineType ? "UNSPECIFIED" : engineType;
                this.engineThrustLbFt = null == engineThrustLbFt ? "0" : engineThrustLbFt;
                this.maxSpeedKnots = null == maxSpeedKnots ? "0" : maxSpeedKnots;
                this.cruiseSpeedKnots = null == cruiseSpeedKnots ? "0" : cruiseSpeedKnots;
                this.ceilingFt = null == ceilingFt ? "0" : ceilingFt;
                this.rateOfClimbFtPerMin = null == rateOfClimbFtPerMin ? "0" : rateOfClimbFtPerMin;
                this.takeoffGroundRunFt = null == takeoffGroundRunFt ? "0" : takeoffGroundRunFt;
                this.landingGroundRollFt = null == landingGroundRollFt ? "0" : landingGroundRollFt;
                this.grossWeightLbs = null == grossWeightLbs ? "0" : grossWeightLbs;
                this.emptyWeightLbs = null == emptyWeightLbs ? "0" : emptyWeightLbs;
                this.lengthFt = null == lengthFt ? "0" : lengthFt;
                this.heightFt = null == heightFt ? "0" : heightFt;
                this.wingSpanFt = null == wingSpanFt ? "0" : wingSpanFt;
                this.rangeNauticalMiles = null == rangeNauticalMiles ? "0" : rangeNauticalMiles;
                this.takeoffOver50ftFt = null == takeoffOver50ftFt ? "0" : takeoffOver50ftFt;
                this.landingOver50ftFt = null == landingOver50ftFt ? "0" : landingOver50ftFt;
        }
}