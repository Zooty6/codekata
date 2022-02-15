package hu.alerant.minimumfinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static java.lang.Character.isDigit;

@Data
@AllArgsConstructor
public class WeatherData implements Comparable<WeatherData> {
    private Integer day;
    private Integer minimumTemperature;
    private Integer maximumTemperature;

    @Override
    public int compareTo(WeatherData o) {
        Integer diff1 = this.getMaximumTemperature() - this.getMinimumTemperature();
        Integer diff2 = o.getMaximumTemperature() - o.getMinimumTemperature();
        return diff1.compareTo(diff2);
    }




}
