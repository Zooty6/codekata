package hu.alerant.weather;

import hu.alerant.weather.model.WeatherData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Optional;

public class Weather {
    public static void main(String[] args) throws IOException {

        String weatherString = loadFile();
        String[] weatherLines = weatherString.split("\n");
        ArrayList<WeatherData> weatherData = new ArrayList<>();


        Optional<Integer> min = weatherData.stream()
                .map(data -> data.getMaximumTemperature() - data.getMinimumTemperature())
                .min();


    }

    private static String loadFile() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("weather.dat");

        if (is == null) {
            throw new NullPointerException("weather data file is missing");
        }

        return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    }
}
