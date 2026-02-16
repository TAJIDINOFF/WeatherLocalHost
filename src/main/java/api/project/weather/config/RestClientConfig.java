package api.project.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration // <-- 1. "Bu yerda sozlamalar bor" belgisi
public class RestClientConfig {

    @Bean // <-- 2. "Mana shu narsani yasab, qutiga solib qo'y"
    public RestClient restClient(RestClient.Builder builder) {
        // Asosiy manzilni shu yerda bir marta yozamiz.
        // Keyinchalik Service ichida faqat davomini ("/current.json") yozsak bo'ldi.
        return builder
                .baseUrl("http://api.weatherapi.com/v1")
                .build();
    }
}