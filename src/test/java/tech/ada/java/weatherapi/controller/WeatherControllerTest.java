//package tech.ada.java.weatherapi.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import tech.ada.java.weatherapi.dto.WeatherDto;
//import tech.ada.java.weatherapi.service.WeatherService;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.ui.Model;
//import tech.ada.java.weatherapi.controller.WeatherController;
//import tech.ada.java.weatherapi.dto.WeatherDto;
//import tech.ada.java.weatherapi.service.WeatherService;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(WeatherController.class)
//class WeatherControllerTest {
//
//    @Mock
//    private WeatherService weatherService;
//
//    @Mock
//    private Model model;
//
//    @InjectMocks
//    private WeatherController weatherController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testWeatherServiceIsCalled() {
//        // Chama o método do controlador que deve chamar o serviço
//        String city = "Fortaleza";
//        weatherController.home(city, model);
//
//        // Verifica se o método do serviço foi chamado com a cidade correta
//        verify(weatherService).getWeather(city);
//    }
//
//}

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
        // Arrange
        String expectedView = "home";

        // Act
        String resultView = weatherController.home(null, model);

        // Assert
        assertEquals(expectedView, resultView);
        verifyNoInteractions(weatherService); // Ensure that weatherService is not called
    }

    @Test
    void home_ReturnsWeatherView_WhenCityProvidedAndWeatherRetrievedSuccessfully() {
        // Arrange
        String cityName = "TestCity";
        WeatherDto weatherDto = WeatherDto.builder().cityName(cityName).build();
        when(weatherService.getWeather(cityName)).thenReturn(weatherDto);
        when(model.addAttribute("weather", weatherDto)).thenReturn(model);
        String expectedView = "weather";

        // Act
        String resultView = weatherController.home(cityName, model);

        // Assert
        assertEquals(expectedView, resultView);
        verify(weatherService, times(1)).getWeather(cityName);
        verify(model, times(1)).addAttribute("weather", weatherDto);
    }

    @Test
    void home_ReturnsErrorView_WhenCityProvidedAndWeatherRetrievalFails() {
        // Arrange
        String cityName = "NonExistentCity";
        when(weatherService.getWeather(cityName)).thenReturn(null);
        String expectedView = "error";

        // Act
        String resultView = weatherController.home(cityName, model);

        // Assert
        assertEquals(expectedView, resultView);
        verify(weatherService, times(1)).getWeather(cityName);
        verifyNoInteractions(model); // Ensure that model is not used in case of an
        }
}
