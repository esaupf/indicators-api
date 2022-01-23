package com.wbip.indicators.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IndicatorData {

    private Indicator indicator;
    private Country country;
    private String countryiso3code;
    private LocalDate date;
    private Number value;
    private String unit;

    @JsonProperty(value = "obsStatus")
    @JsonAlias(value = "obs_status")
    private String obsStatus;
    private Integer decimal;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Indicator {

        private String id;
        private String value;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Country {

        private String code;
        private String name;

    }


}
