package api.project.weather.exception;

import api.project.weather.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@RestControllerAdvice // <-- DIQQAT: Bu "Men hamma Controllerlarni nazorat qilaman" degani
public class GlobalExceptionHandler {

    // 1. Agar WeatherAPI dan xato kelsa (masalan, shahar topilmasa)
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleWeatherApiError(HttpClientErrorException e) {
        ErrorResponse error = new ErrorResponse(
                "Ob-havo xizmatida xatolik: Shahar topilmadi yoki API kalit noto'g'ri.",
                e.getStatusCode().value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, e.getStatusCode());
    }

    // 2. Agar bizning seyfimizda kalit yo'q bo'lsa (o'zimiz yozgan RuntimeException)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleInternalError(RuntimeException e) {
        ErrorResponse error = new ErrorResponse(
                e.getMessage(), // "API Key topilmadi!" degan xabar shu yerga tushadi
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}