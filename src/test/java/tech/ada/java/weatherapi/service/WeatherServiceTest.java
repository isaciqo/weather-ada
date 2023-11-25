package tech.ada.java.weatherapi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.ada.java.weatherapi.client.WeatherClient;
import tech.ada.java.weatherapi.dto.WeatherDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private WeatherClient weatherClient;

    @InjectMocks
    private WeatherService weatherService;

    @Test
    void getWeather_ReturnsWeatherDto_WhenCityIsValid() {
        String validCity = "London";
        WeatherDto mockWeatherDto = buildMockWeatherDto();

        when(weatherClient.getWeatherForCity(validCity)).thenReturn(mockWeatherDto);

        WeatherDto result = weatherService.getWeather(validCity);

        assertEquals(mockWeatherDto, result);
    }

    @Test
    void getWeather_ReturnsNull_WhenCityIsNull() {
        WeatherDto result = weatherService.getWeather(null);
        assertNull(result);
    }
    @Test
    void getWeather_ReturnsNull_WhenCityIsEmpty() {
        WeatherDto result = weatherService.getWeather("");
        assertNull(result);
    }
    private WeatherDto buildMockWeatherDto() {
        return WeatherDto.builder().cityName("London").cityTemp("25°C").build();
    }
}