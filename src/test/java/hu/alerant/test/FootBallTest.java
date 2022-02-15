package hu.alerant.test;

import hu.alerant.football.Football;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootBallTest {

    @Test
    public void testFootballMinimumDay() {
        assertEquals("Aston_Villa", new Football().getSmallestDifferenceTeam());
    }
}
