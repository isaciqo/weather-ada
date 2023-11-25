package tech.ada.java.weatherapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OpenWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
    private List<OpenWeatherWeatherDto> weather;
    private String name;
    private String weatherIcon;
}
