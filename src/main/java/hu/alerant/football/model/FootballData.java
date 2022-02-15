package hu.alerant.football.model;

import lombok.Data;

@Data
public class FootballData {
    private int f;
    private int a;
    private String teamName;

    public FootballData(String dataLine) {
        parseName(dataLine);
        parseFAndA(dataLine);
    }

    private void parseName(String dataLine) {
        StringBuilder part = new StringBuilder();
        for (int i = 7; i < 23; i++) {
            part.append(dataLine.charAt(i));
        }
        this.teamName = part.toString().trim();

    }

    private void parseFAndA(String dataLine) {
        StringBuilder part = new StringBuilder();
        for (int i = 43; i < 55; i++) {
            part.append(dataLine.charAt(i));
        }
        String[] split = part.toString().split("-");
        this.f = Integer.parseInt(split[0].trim());
        this.a = Integer.parseInt(split[1].trim());
    }
}
