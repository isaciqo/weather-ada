package tech.ada.java.weatherapi.config;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Getter
public class WeatherIconConfig {

    @Bean
    public Map<Integer, String> weatherIcons() {

        return new HashMap<>() {{
            put(200, "storm");
            put(201, "storm");
            put(202, "storm");
            put(210, "storm");
            put(211, "storm");
            put(212, "storm");
            put(221, "storm");
            put(230, "storm");
            put(231, "storm");
            put(232, "storm");
            put(300, "drizzle");
            put(301, "drizzle");
            put(302, "drizzle");
            put(310, "drizzle");
            put(311, "drizzle");
            put(312, "drizzle");
            put(313, "drizzle");
            put(314, "drizzle");
            put(321, "drizzle");
            put(500, "rain");
            put(501, "rain");
            put(502, "rain");
            put(503, "rain");
            put(504, "rain");
            put(511, "rain");
            put(520, "rain");
            put(521, "rain");
            put(522, "rain");
            put(531, "rain");
            put(600, "snow");
            put(601, "snow");
            put(602, "snow");
            put(611, "snow");
            put(612, "snow");
            put(613, "snow");
            put(615, "snow");
            put(616, "snow");
            put(620, "snow");
            put(621, "snow");
            put(622, "snow");
            put(701, "mist");
            put(711, "mist");
            put(721, "mist");
            put(731, "mist");
            put(741, "mist");
            put(751, "mist");
            put(761, "mist");
            put(762, "mist");
            put(771, "mist");
            put(781, "mist");
            put(800, "clear");
            put(801, "clouds");
            put(802, "clouds");
            put(803, "clouds");
            put(804, "clouds");
        }};
    }
}