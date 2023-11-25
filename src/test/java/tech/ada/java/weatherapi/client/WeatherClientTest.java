package tech.ada.java.weatherapi.client;//package tech.ada.java.weatherapi.client;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class WeatherClientTest {
//
//    @Test
//    void getWeatherForCity() {
//    }
//}

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import tech.ada.java.weatherapi.client.WeatherClient;
import tech.ada.java.weatherapi.dto.WeatherDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.ada.java.weatherapi.client.WeatherClient;
import tech.ada.java.weatherapi.config.WeatherIconConfig;
import tech.ada.java.weatherapi.dto.WeatherDto;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;



class WeatherClientTest {

    private WeatherClient weatherClient;
    private WeatherIconConfig weatherIconConfig;

    @BeforeEach
    void setUp() {
        Map<Integer, String> weatherIcons = new HashMap<>();
        weatherIcons.put(200, "icon-200"); // Exemplo de ícone para ID 200
        weatherClient = new WeatherClient(weatherIcons); // Você precisará instanciar o WeatherClient aqui
    }

    @Test
    void testGetWeatherForFortaleza() {
        // Chamar o método getWeatherForCity com Fortaleza

        System.out.println("--------------entrou no teste---------------------------");
        WeatherDto weather = weatherClient.getWeatherForCity("Fortaleza");
        System.out.println("--------------weather---------------------------" + weather.getCityTemp());
        // Verificar se o resultado retornado não é nulo
        assertNotNull(weather);
        // Adicione mais verificações conforme necessário com base na resposta esperada da API para Fortaleza
        // ...
    }
}