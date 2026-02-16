package api.project.weather.service;

import api.project.weather.dto.WeatherResponse; // <-- Yangi import
import api.project.weather.store.ApiKeyStore;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;
    private final ApiKeyStore apiKeyStore;

    public WeatherService(RestClient restClient, ApiKeyStore apiKeyStore) {
        this.restClient = restClient;
        this.apiKeyStore = apiKeyStore;
    }

    // E'tibor bering: Return type endi String emas, WeatherResponse!
    public WeatherResponse getWeather(String city) {
        String key = apiKeyStore.getKey()
                .orElseThrow(() -> new RuntimeException("API Key topilmadi!"));

        return restClient.get()
                .uri("/current.json?key={key}&q={city}", key, city)
                .retrieve()
                .body(WeatherResponse.class); // <-- MANA SEHR! String.class o'rniga
    }
}