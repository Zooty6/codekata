package hu.alerant.weather;

import hu.alerant.weather.model.WeatherData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Weather {
    public static void main(String[] args) throws IOException {

        String weatherString = loadFile();
        String[] weatherLines = weatherString.split("\n");
        ArrayList<WeatherData> weatherData = new ArrayList<>();

        for (int i = 2; i < weatherLines.length; i++) {
            String weatherLine = weatherLines[i];
            if (!weatherLine.trim().startsWith("mo")) {
                weatherData.add(new WeatherData(weatherLine));
            }
        }

        WeatherData minimumData = weatherData.stream()
                .min((o1, o2) -> {
                    Integer one = (o1.getMaximumTemperature() - o1.getMinimumTemperature());
                    Integer two = o2.getMaximumTemperature() - o2.getMinimumTemperature();
                    return one.compareTo(two);
                })
                .orElse(null);

        System.out.println("minimum temperature day: " + (minimumData != null ? minimumData.getDay() : "null"));


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
