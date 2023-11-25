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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private WeatherClient weatherClient;

    @InjectMocks
    private WeatherService weatherService;

    @Test
    void getWeather_ReturnsWeatherDto_WhenCityIsValid() {
        // Arrange
        String validCity = "London";
        WeatherDto mockWeatherDto = buildMockWeatherDto();

        when(weatherClient.getWeatherForCity(validCity)).thenReturn(mockWeatherDto);

        // Act
        WeatherDto result = weatherService.getWeather(validCity);

        // Assert
        assertEquals(mockWeatherDto, result);
    }

    @Test
    void getWeather_ReturnsNull_WhenCityIsNull() {
        // Act
        WeatherDto result = weatherService.getWeather(null);

        // Assert
        assertNull(result);
    }

    @Test
    void getWeather_ReturnsNull_WhenCityIsEmpty() {
        // Act
        WeatherDto result = weatherService.getWeather("");

        // Assert
        assertNull(result);
    }

    // Helper method to create a mock WeatherDto for testing
    private WeatherDto buildMockWeatherDto() {
        // Implement based on your actual structure and requirements
        return WeatherDto.builder().cityName("London").cityTemp("25°C").build();
    }
}