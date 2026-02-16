package api.project.weather.controller;

import api.project.weather.dto.WeatherResponse; // <-- Import
import api.project.weather.service.WeatherService;
import api.project.weather.store.ApiKeyStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    private final WeatherService weatherService;
    private final ApiKeyStore apiKeyStore;

    public WeatherController(WeatherService weatherService, ApiKeyStore apiKeyStore) {
        this.weatherService = weatherService;
        this.apiKeyStore = apiKeyStore;
    }

    @PostMapping("/api-key")
    public ResponseEntity<String> setApiKey(@RequestBody String key) {
        apiKeyStore.setKey(key);
        return ResponseEntity.ok("API Key saqlandi");
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }
}