package tech.ada.java.weatherapi.client;

import org.junit.jupiter.api.Test;
import tech.ada.java.weatherapi.dto.WeatherDto;
import org.junit.jupiter.api.BeforeEach;
import tech.ada.java.weatherapi.config.WeatherIconConfig;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;



class WeatherClientTest {

    private WeatherClient weatherClient;
    private WeatherIconConfig weatherIconConfig;

    @BeforeEach
    void setUp() {
        Map<Integer, String> weatherIcons = new HashMap<>();
        weatherIcons.put(200, "icon-200");
        weatherClient = new WeatherClient(weatherIcons);
    }

    @Test
    void testGetWeatherForFortaleza() {

        WeatherDto weather = weatherClient.getWeatherForCity("Fortaleza");

        assertNotNull(weather);
    }
}