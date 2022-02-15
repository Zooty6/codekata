package hu.alerant.minimumfinder;

import hu.alerant.minimumfinder.model.FootballData;
import hu.alerant.minimumfinder.model.WeatherData;

public class MinimumDiffFinder {
    WeatherParser weatherParser = new WeatherParser();
    FootballParser footballParser = new FootballParser();
    DataLoader dataLoader = new DataLoader();

    public String findFootballMinimumGoalDifferenceTeamName() {
        return dataLoader.load("football.dat").stream()
                .filter(footballParser::isValidData)
                .map(footballParser::parse)
                .min(FootballData::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Error during calculation"))
                .getTeamName();
    }

    public Integer findSmallestTemperatureDifferenceDay() {
        return dataLoader.load("weather.dat").stream()
                .filter(weatherParser::isValidData)
                .map(weatherParser::parse)
                .min(WeatherData::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Error during calculation"))
                .getDay();
    }
}
