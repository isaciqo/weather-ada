package tech.ada.java.weatherapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ada.java.weatherapi.client.WeatherClient;
import tech.ada.java.weatherapi.dto.WeatherDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    public WeatherDto getWeather(String city) {
        return weatherClient.getWeatherForCity(city);
    }

}
