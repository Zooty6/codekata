package hu.alerant.test;

import hu.alerant.weather.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTest {

    @Test
    public void testSmallestDifferenceDay() throws IOException {
        assertEquals(14, new Weather().findSmallestTemperatureDifferenceDay());
    }
}
