package tech.ada.java.weatherapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {


    private float temp;
    private String cityTemp;
    private int weatherId;
    private String cityName;
    private int pressure;
    private int humidity;
    private float windSpeed;
    private String weatherIcon;
}
