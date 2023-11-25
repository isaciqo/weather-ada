package tech.ada.java.weatherapi.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tech.ada.java.weatherapi.dto.WeatherDto;
import tech.ada.java.weatherapi.service.WeatherService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @Test
    void home_ReturnsHomePage_WhenCityIsNull() throws Exception {
        // Arrange
        when(weatherService.getWeather(anyString())).thenReturn(null);

        // Act and Assert
        mockMvc.perform(get("/weather"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeDoesNotExist("weather"));
    }

    @Test
    void home_ReturnsWeatherPage_WhenCityIsValid() throws Exception {
        // Arrange
        String validCity = "Paris";
        WeatherDto mockWeatherDto = buildMockWeatherDto();

        when(weatherService.getWeather(validCity)).thenReturn(mockWeatherDto);

        // Act and Assert
        mockMvc.perform(get("/weather").param("city", validCity))
                .andExpect(status().isOk())
                .andExpect(view().name("weather"))
                .andExpect(model().attribute("weather", mockWeatherDto));
    }

    // Helper method to create a mock WeatherDto for testing
    private WeatherDto buildMockWeatherDto() {
        // Implement based on your actual structure and requirements
        return WeatherDto.builder().cityName("Paris").cityTemp("22°C").build();
    }
}