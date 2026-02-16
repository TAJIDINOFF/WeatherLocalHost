package api.project.weather.store;

import org.springframework.stereotype.Component;
import java.util.Optional;

@Component // <-- 1. Springga aytamiz: "Buni o'z qaramog'ingga ol"
public class ApiKeyStore {

    private String apiKey; // <-- 2. Kalit shu yerda yashirinadi

    // Kalitni seyfga solish (POST uchun)
    public void setKey(String key) {
        this.apiKey = key;
    }

    // Kalitni olish (Service uchun)
    // Nega Optional? Chunki kalit hali qo'yilmagan bo'lishi mumkin (null).
    // Optional bizni "NullPointerException" xatosidan qutqaradi.
    public Optional<String> getKey() {
        return Optional.ofNullable(apiKey);
    }
}