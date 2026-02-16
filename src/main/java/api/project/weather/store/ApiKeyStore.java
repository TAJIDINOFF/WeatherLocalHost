package api.project.weather.store;

import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ApiKeyStore {

    private String apiKey;


    public void setKey(String key) {
        this.apiKey = key;
    }

    public Optional<String> getKey() {
        return Optional.ofNullable(apiKey);
    }
}