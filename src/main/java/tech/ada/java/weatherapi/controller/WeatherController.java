package tech.ada.java.weatherapi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.ada.java.weatherapi.service.WeatherService;
import tech.ada.java.weatherapi.dto.WeatherDto;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String home(@RequestParam(required = false) String city, Model model) {
        if (city == null || city.isEmpty()) {
            return "home";
        }

        WeatherDto weather = weatherService.getWeather(city);
        if (weather == null) {
            return "error";
        }

        model.addAttribute("weather", weather);
        return "weather";
    }
}

