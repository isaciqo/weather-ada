package tech.ada.java.weatherapi.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OpenWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;
    private List<OpenWeatherWeatherDto> weather;
    private String name;
    private String weatherIcon;
}
