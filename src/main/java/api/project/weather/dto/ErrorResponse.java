package api.project.weather.dto;

import java.time.LocalDateTime;

// Xatoni chiroyli ko'rsatish uchun qolip
public record ErrorResponse(
        String message,   // "Shahar topilmadi"
        int status,       // 404 yoki 400
        LocalDateTime time // Xato chiqqan vaqt
) {}