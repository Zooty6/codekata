package hu.alerant.weather.model;

import lombok.Data;

@Data
public class WeatherData {
    private int minimumTemperature;
    private int maximumTemperature;
    // TODO: rest

    WeatherData(String input) {

    }
}
