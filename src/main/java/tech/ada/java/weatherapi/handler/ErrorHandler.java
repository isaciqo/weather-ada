package tech.ada.java.weatherapi.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public String handleCityNotFoundError() {
        return "error";
    }
}

