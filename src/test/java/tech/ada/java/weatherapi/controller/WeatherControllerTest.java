package tech.ada.java.weatherapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import tech.ada.java.weatherapi.dto.WeatherDto;
import tech.ada.java.weatherapi.service.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @Mock
    private Model model;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void home_ReturnsHomeView_WhenNoCityProvided() {
        String expectedView = "home";

        String resultView = weatherController.home(null, model);

        assertEquals(expectedView, resultView);
        verifyNoInteractions(weatherService);
    }

    @Test
    void home_ReturnsWeatherView_WhenCityProvidedAndWeatherRetrievedSuccessfully() {

        String cityName = "TestCity";
        WeatherDto weatherDto = WeatherDto.builder().cityName(cityName).build();
        when(weatherService.getWeather(cityName)).thenReturn(weatherDto);
        when(model.addAttribute("weather", weatherDto)).thenReturn(model);
        String expectedView = "weather";

        String resultView = weatherController.home(cityName, model);

        assertEquals(expectedView, resultView);
        verify(weatherService, times(1)).getWeather(cityName);
        verify(model, times(1)).addAttribute("weather", weatherDto);
    }

    @Test
    void home_ReturnsErrorView_WhenCityProvidedAndWeatherRetrievalFails() {

        String cityName = "NonExistentCity";
        when(weatherService.getWeather(cityName)).thenReturn(null);
        String expectedView = "error";

        String resultView = weatherController.home(cityName, model);

        assertEquals(expectedView, resultView);
        verify(weatherService, times(1)).getWeather(cityName);
        verifyNoInteractions(model);
        }
}
