package hu.alerant.minimumfinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FootballData implements Comparable<FootballData> {
    private int f;
    private int a;
    private String teamName;



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


    @Override
    public int compareTo(FootballData o) {
        Integer diff1 = Math.abs(this.getF() - this.getA());
        Integer diff2 = Math.abs(o.getF() - o.getA());
        return diff1.compareTo(diff2);
    }
}
