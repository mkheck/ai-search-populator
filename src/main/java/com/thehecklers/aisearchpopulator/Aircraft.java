package com.thehecklers.aisearchpopulator;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Aircraft {
    private String manufacturer;
    private String model;
    private String engineType;
    private Integer engineThrustLbFt;
    private Float maxSpeedKnots;
    private Float cruiseSpeedKnots;
    private Integer ceilingFt;
    private Integer rateOfClimbFtPerMin;
    private Integer takeoffGroundRunFt;
    private Integer landingGroundRollFt;
    private Integer grossWeightLbs;
    private Integer emptyWeightLbs;
    private Float lengthFt;
    private Float heightFt;
    private Float wingSpanFt;
    private Integer rangeNauticalMiles;
    private Integer takeoffOver50ftFt;
    private Integer landingOver50ftFt;

    // MUCH sanitizing of input data was required
    public Aircraft(String manufacturer,
                    String model,
                    @JsonProperty("engine_type") String engineType,
                    @JsonProperty("engine_thrust_lb_ft") Integer engineThrustLbFt,
                    @JsonProperty("max_speed_knots") Float maxSpeedKnots,
                    @JsonProperty("cruise_speed_knots") String cruiseSpeedKnots,
                    @JsonProperty("ceiling_ft") Integer ceilingFt,
                    @JsonProperty("rate_of_climb_ft_per_min") Integer rateOfClimbFtPerMin,
                    @JsonProperty("takeoff_ground_run_ft") Integer takeoffGroundRunFt,
                    @JsonProperty("landing_ground_roll_ft") Integer landingGroundRollFt,
                    @JsonProperty("gross_weight_lbs") Integer grossWeightLbs,
                    @JsonProperty("empty_weight_lbs") Integer emptyWeightLbs,
                    @JsonProperty("length_ft") Float lengthFt,
                    @JsonProperty("height_ft") Float heightFt,
                    @JsonProperty("wing_span_ft") Float wingSpanFt,
                    @JsonProperty("range_nautical_miles") String rangeNauticalMiles,
                    @JsonProperty("takeoff_over_50ft_ft") Integer takeoffOver50ftFt,
                    @JsonProperty("landing_over_50ft_ft") Integer landingOver50ftFt) {

        this.manufacturer = manufacturer;
        this.model = model;
        this.engineType = null == engineType ? "UNSPECIFIED" : engineType;
        this.engineThrustLbFt = null == engineThrustLbFt ? -1 : engineThrustLbFt;
        this.maxSpeedKnots = null == maxSpeedKnots ? -1F : maxSpeedKnots;
        this.cruiseSpeedKnots = null == cruiseSpeedKnots ? -1F : cruiseSpeedKnots.endsWith(" kts")
                ? Float.parseFloat(cruiseSpeedKnots.replace(" kts", ""))
                : Float.valueOf(cruiseSpeedKnots);
        this.ceilingFt = null == ceilingFt ? -1 : ceilingFt;
        this.rateOfClimbFtPerMin = null == rateOfClimbFtPerMin ? -1 : rateOfClimbFtPerMin;
        this.takeoffGroundRunFt = null == takeoffGroundRunFt ? -1 : takeoffGroundRunFt;
        this.landingGroundRollFt = null == landingGroundRollFt ? -1 : landingGroundRollFt;
        this.grossWeightLbs = null == grossWeightLbs ? -1 : grossWeightLbs;
        this.emptyWeightLbs = null == emptyWeightLbs ? -1 : emptyWeightLbs;
        this.lengthFt = null == lengthFt ? -1F : lengthFt;
        this.heightFt = null == heightFt ? -1F : heightFt;
        this.wingSpanFt = null == wingSpanFt ? -1F : wingSpanFt;
        this.rangeNauticalMiles = null == rangeNauticalMiles ? -1 : rangeNauticalMiles.matches("\\d+")
                ? Integer.parseInt(rangeNauticalMiles)
                : Integer.parseInt(rangeNauticalMiles.substring(0, rangeNauticalMiles.length() - 1).replaceAll(",", ""));
        this.takeoffOver50ftFt = null == takeoffOver50ftFt ? -1 : takeoffOver50ftFt;
        this.landingOver50ftFt = null == landingOver50ftFt ? -1 : landingOver50ftFt;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getEngineType() {
        return engineType;
    }

    public Integer getEngineThrustLbFt() {
        return engineThrustLbFt;
    }

    public Float getMaxSpeedKnots() {
        return maxSpeedKnots;
    }

    public Float getCruiseSpeedKnots() {
        return cruiseSpeedKnots;
    }

    public Integer getCeilingFt() {
        return ceilingFt;
    }

    public Integer getRateOfClimbFtPerMin() {
        return rateOfClimbFtPerMin;
    }

    public Integer getTakeoffGroundRunFt() {
        return takeoffGroundRunFt;
    }

    public Integer getLandingGroundRollFt() {
        return landingGroundRollFt;
    }

    public Integer getGrossWeightLbs() {
        return grossWeightLbs;
    }

    public Integer getEmptyWeightLbs() {
        return emptyWeightLbs;
    }

    public Float getLengthFt() {
        return lengthFt;
    }

    public Float getHeightFt() {
        return heightFt;
    }

    public Float getWingSpanFt() {
        return wingSpanFt;
    }

    public Integer getRangeNauticalMiles() {
        return rangeNauticalMiles;
    }

    public Integer getTakeoffOver50ftFt() {
        return takeoffOver50ftFt;
    }

    public Integer getLandingOver50ftFt() {
        return landingOver50ftFt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Objects.equals(manufacturer, aircraft.manufacturer) && Objects.equals(model, aircraft.model) && Objects.equals(engineType, aircraft.engineType) && Objects.equals(engineThrustLbFt, aircraft.engineThrustLbFt) && Objects.equals(maxSpeedKnots, aircraft.maxSpeedKnots) && Objects.equals(cruiseSpeedKnots, aircraft.cruiseSpeedKnots) && Objects.equals(ceilingFt, aircraft.ceilingFt) && Objects.equals(rateOfClimbFtPerMin, aircraft.rateOfClimbFtPerMin) && Objects.equals(takeoffGroundRunFt, aircraft.takeoffGroundRunFt) && Objects.equals(landingGroundRollFt, aircraft.landingGroundRollFt) && Objects.equals(grossWeightLbs, aircraft.grossWeightLbs) && Objects.equals(emptyWeightLbs, aircraft.emptyWeightLbs) && Objects.equals(lengthFt, aircraft.lengthFt) && Objects.equals(heightFt, aircraft.heightFt) && Objects.equals(wingSpanFt, aircraft.wingSpanFt) && Objects.equals(rangeNauticalMiles, aircraft.rangeNauticalMiles) && Objects.equals(takeoffOver50ftFt, aircraft.takeoffOver50ftFt) && Objects.equals(landingOver50ftFt, aircraft.landingOver50ftFt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, engineType, engineThrustLbFt, maxSpeedKnots, cruiseSpeedKnots, ceilingFt, rateOfClimbFtPerMin, takeoffGroundRunFt, landingGroundRollFt, grossWeightLbs, emptyWeightLbs, lengthFt, heightFt, wingSpanFt, rangeNauticalMiles, takeoffOver50ftFt, landingOver50ftFt);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineThrustLbFt=" + engineThrustLbFt +
                ", maxSpeedKnots=" + maxSpeedKnots +
                ", cruiseSpeedKnots=" + cruiseSpeedKnots +
                ", ceilingFt=" + ceilingFt +
                ", rateOfClimbFtPerMin=" + rateOfClimbFtPerMin +
                ", takeoffGroundRunFt=" + takeoffGroundRunFt +
                ", landingGroundRollFt=" + landingGroundRollFt +
                ", grossWeightLbs=" + grossWeightLbs +
                ", emptyWeightLbs=" + emptyWeightLbs +
                ", lengthFt=" + lengthFt +
                ", heightFt=" + heightFt +
                ", wingSpanFt=" + wingSpanFt +
                ", rangeNauticalMiles=" + rangeNauticalMiles +
                ", takeoffOver50ftFt=" + takeoffOver50ftFt +
                ", landingOver50ftFt=" + landingOver50ftFt +
                '}';
    }
}