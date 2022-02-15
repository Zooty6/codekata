package hu.alerant.test;

import hu.alerant.minimumfinder.MinimumDiffFinder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumTest {
    @Test
    public void testWeather() {
        assertEquals(14, new MinimumDiffFinder().findSmallestTemperatureDifferenceDay());
    }

    @Test
    public void testFootball() {
        assertEquals("Aston_Villa", new MinimumDiffFinder().findFootballMinimumGoalDifferenceTeamName());
    }
}
