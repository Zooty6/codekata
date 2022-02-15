package hu.alerant.minimumfinder.parser;

import hu.alerant.minimumfinder.model.WeatherData;

import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class WeatherParser implements Parser<WeatherData> {
    @Override
    public WeatherData parse(String record) {
        StringBuilder unit = new StringBuilder();
        ArrayList<String> units = new ArrayList<>();
        for (int i = 0; i < record.length(); i++) {
            if (isDigit(record.charAt(i))) {
                unit.append(record.charAt(i));
            } else {
                if(!unit.toString().isBlank()) {
                    units.add(unit.toString());
                }
                unit = new StringBuilder();
            }
        }

        var day = Integer.parseInt(units.get(0));
        var maximumTemperature = Integer.parseInt(units.get(1));
        var minimumTemperature = Integer.parseInt(units.get(2));

        return new WeatherData(day, minimumTemperature, maximumTemperature);
    }

    public boolean isValidLine(String line) {
        return !line.trim().isEmpty() && isDigit(line.trim().charAt(0));
    }
}
