package com.thehecklers.aisearchpopulator;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Aircraft(
        String manufacturer,
        String model,
        String engineType,
        Integer engineThrustLbFt,
        Integer maxSpeedKnots,
        Integer cruiseSpeedKnots,
        Integer ceilingFt,
        Integer rateOfClimbFtPerMin,
        Integer takeoffGroundRunFt,
        Integer landingGroundRollFt,
        Integer grossWeightLbs,
        Integer emptyWeightLbs,
        Float lengthFt,
        Float heightFt,
        Float wingSpanFt,
        Integer rangeNauticalMiles,
        Integer takeoffOver50ftFt,
        Integer landingOver50ftFt
) {
        // Clean up the many, many nulls inbound on which VectorStore chokes
        public Aircraft(String manufacturer, 
                        String model,
                        @JsonProperty("engine_type")
                        String engineType,
                        @JsonProperty("engine_thrust_lb_ft")
                        Integer engineThrustLbFt,
                        @JsonProperty("max_speed_knots")
                        Integer maxSpeedKnots,
                        @JsonProperty("cruise_speed_knots")
                        Integer cruiseSpeedKnots,
                        @JsonProperty("ceiling_ft")
                        Integer ceilingFt,
                        @JsonProperty("rate_of_climb_ft_per_min")
                        Integer rateOfClimbFtPerMin,
                        @JsonProperty("takeoff_ground_run_ft")
                        Integer takeoffGroundRunFt,
                        @JsonProperty("landing_ground_roll_ft")
                        Integer landingGroundRollFt,
                        @JsonProperty("gross_weight_lbs")
                        Integer grossWeightLbs,
                        @JsonProperty("empty_weight_lbs")
                        Integer emptyWeightLbs,
                        @JsonProperty("length_ft")
                        Float lengthFt,
                        @JsonProperty("height_ft")
                        Float heightFt,
                        @JsonProperty("wing_span_ft")
                        Float wingSpanFt,
                        @JsonProperty("range_nautical_miles")
                        Integer rangeNauticalMiles,
                        @JsonProperty("takeoff_over_50ft_ft")
                        Integer takeoffOver50ftFt,
                        @JsonProperty("landing_over_50ft_ft")
                        Integer landingOver50ftFt) {
                this.manufacturer = manufacturer;
                this.model = model;
                this.engineType = null == engineType ? "UNSPECIFIED" : engineType;
                this.engineThrustLbFt = null == engineThrustLbFt ? -1 : engineThrustLbFt;
                this.maxSpeedKnots = null == maxSpeedKnots ? -1 : maxSpeedKnots;
                this.cruiseSpeedKnots = null == cruiseSpeedKnots ? -1 : cruiseSpeedKnots;
                this.ceilingFt = null == ceilingFt ? -1 : ceilingFt;
                this.rateOfClimbFtPerMin = null == rateOfClimbFtPerMin ? -1 : rateOfClimbFtPerMin;
                this.takeoffGroundRunFt = null == takeoffGroundRunFt ? -1 : takeoffGroundRunFt;
                this.landingGroundRollFt = null == landingGroundRollFt ? -1 : landingGroundRollFt;
                this.grossWeightLbs = null == grossWeightLbs ? -1 : grossWeightLbs;
                this.emptyWeightLbs = null == emptyWeightLbs ? -1 : emptyWeightLbs;
                this.lengthFt = null == lengthFt ? -1F : lengthFt;
                this.heightFt = null == heightFt ? -1F : heightFt;
                this.wingSpanFt = null == wingSpanFt ? -1F : wingSpanFt;
                this.rangeNauticalMiles = null == rangeNauticalMiles ? -1 : rangeNauticalMiles;
                this.takeoffOver50ftFt = null == takeoffOver50ftFt ? -1 : takeoffOver50ftFt;
                this.landingOver50ftFt = null == landingOver50ftFt ? -1 : landingOver50ftFt;
        }
}