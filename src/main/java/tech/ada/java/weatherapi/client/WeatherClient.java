package tech.ada.java.weatherapi.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tech.ada.java.weatherapi.dto.OpenWeatherDto;
import tech.ada.java.weatherapi.dto.WeatherDto;

import java.util.Map;

@Component
public class WeatherClient {

    private final Map<Integer, String> weatherIcons;

    RestTemplate restTemplate = new RestTemplate();

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";

    @Value("${api.key}")
    private String API_KEY;

    public WeatherClient(Map<Integer, String> weatherIcons) {
        this.weatherIcons = weatherIcons;
    }

    public WeatherDto getWeatherForCity(String city) {

        OpenWeatherDto openWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=en",
                OpenWeatherDto.class,
                city, API_KEY);

        int weatherId = openWeatherDto.getWeather().get(0).getId();
        String weatherIcon = weatherIcons.get(weatherId);

        String temperatureString = String.format("%d°C", (int) openWeatherDto.getMain().getTemp());

        return WeatherDto.builder()
                .cityTemp(temperatureString)
                .cityName(openWeatherDto.getName())
                .weatherId(weatherId)
                .weatherIcon(weatherIcon)
                .humidity(openWeatherDto.getMain().getHumidity())
                .pressure(openWeatherDto.getMain().getPressure())
                .windSpeed(openWeatherDto.getWind().getSpeed())
                .build();

    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}
