package hu.alerant.weather;

import hu.alerant.weather.model.WeatherData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Weather {
    public Integer findSmallestTemperatureDifferenceDay() throws IOException {
        String[] weatherLines = loadFile();
        ArrayList<WeatherData> weatherData = parseWeatherData(weatherLines);
        WeatherData minimumData = getMinimumDayData(weatherData);

        return minimumData.getDay();
    }

    private static String[] loadFile() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream weatherRawStream = classLoader.getResourceAsStream("weather.dat");

        if (weatherRawStream == null) {
            throw new NullPointerException("weather data file is missing");
        }

        String fileContent = new String(weatherRawStream.readAllBytes(), StandardCharsets.UTF_8);

        return fileContent.split("\n");
    }

    private ArrayList<WeatherData> parseWeatherData(String[] weatherLines) {
        ArrayList<WeatherData> weatherData = new ArrayList<>();
        for (int i = 2; i < weatherLines.length; i++) {
            String weatherLine = weatherLines[i];
            if (!weatherLine.trim().startsWith("mo")) {
                weatherData.add(new WeatherData(weatherLine));
            }
        }
        return weatherData;
    }

    private WeatherData getMinimumDayData(ArrayList<WeatherData> weatherData) {
        return weatherData.stream()
                .min(Weather::compareByDayDifference)
                .orElse(null);
    }

    private static int compareByDayDifference(WeatherData o1, WeatherData o2) {
        Integer diff1 = o1.getMaximumTemperature() - o1.getMinimumTemperature();
        Integer diff2 = o2.getMaximumTemperature() - o2.getMinimumTemperature();
        return diff1.compareTo(diff2);
    }
}
