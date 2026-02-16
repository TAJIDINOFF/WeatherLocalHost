package api.project.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// 1. Asosiy quti (Root)
public record WeatherResponse(
        Location location,
        Current current
) {}

// 2. Joylashuv ma'lumotlari
record Location(
        String name,
        String country
) {}

// 3. Ob-havo ma'lumotlari
record Current(
        @JsonProperty("temp_c") double temperature, // JSONda "temp_c", bizda "temperature"
        Condition condition
) {}

// 4. Holat (Masalan: "Sunny")
record Condition(
        String text
) {}