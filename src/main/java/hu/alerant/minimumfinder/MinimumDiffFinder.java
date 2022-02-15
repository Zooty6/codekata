package hu.alerant.minimumfinder;

import hu.alerant.minimumfinder.model.FootballData;
import hu.alerant.minimumfinder.model.WeatherData;
import hu.alerant.minimumfinder.parser.FootballParser;
import hu.alerant.minimumfinder.parser.Parser;
import hu.alerant.minimumfinder.parser.WeatherParser;

public class MinimumDiffFinder {
    Parser<WeatherData> weatherParser = new WeatherParser();
    Parser<FootballData> footballParser = new FootballParser();
    DataLoader dataLoader = new DataLoader();

    public String findFootballMinimumGoalDifferenceTeamName() {
        return dataLoader.load("football.dat").stream()
                .filter(footballParser::isValidLine)
                .map(footballParser::parse)
                .min(FootballData::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Error during calculation"))
                .getTeamName();
    }

    public Integer findSmallestTemperatureDifferenceDay() {
        return dataLoader.load("weather.dat").stream()
                .filter(weatherParser::isValidLine)
                .map(weatherParser::parse)
                .min(WeatherData::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Error during calculation"))
                .getDay();
    }
}
