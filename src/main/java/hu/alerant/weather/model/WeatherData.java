package hu.alerant.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static java.lang.Character.isDigit;

@Data
@NoArgsConstructor
public class WeatherData {
    private int day;
    private int minimumTemperature;
    private int maximumTemperature;
    // TODO: rest

    public WeatherData(String input) {
        StringBuilder unit = new StringBuilder();
        ArrayList<String> units = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isDigit(input.charAt(i))) {
                unit.append(input.charAt(i));
            } else {
                if(!unit.toString().isBlank()) {
                    units.add(unit.toString());
                }
                unit = new StringBuilder();
            }
        }

        day = Integer.parseInt(units.get(0));
        maximumTemperature = Integer.parseInt(units.get(1));
        minimumTemperature = Integer.parseInt(units.get(2));
    }
}
