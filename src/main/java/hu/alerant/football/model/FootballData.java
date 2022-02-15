package hu.alerant.football.model;

import lombok.Data;

@Data
public class FootballData {
    private int F;
    private int A;
    private String teamName;

    public FootballData(String dataLine) {
    }
}
