package api.project.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record WeatherResponse(
        Location location,
        Current current
) {}


record Location(
        String name,
        String country
) {}


record Current(
        @JsonProperty("temp_c") double temperature,
        Condition condition
) {}


record Condition(
        String text
) {}