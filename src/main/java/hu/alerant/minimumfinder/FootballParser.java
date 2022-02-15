package hu.alerant.minimumfinder;

import hu.alerant.minimumfinder.model.FootballData;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Character.isDigit;

public class FootballParser {

    public FootballData parse(String record) {
        String name = parseName(record);
        FAPackage fa = parseFAndA(record);

        return new FootballData(fa.f, fa.a, name);
    }

    public boolean isValidData(String line) {
        return !line.trim().isEmpty() && isDigit(line.trim().charAt(0));
    }


    private String parseName(String dataLine) {
        StringBuilder part = new StringBuilder();
        for (int i = 7; i < 23; i++) {
            part.append(dataLine.charAt(i));
        }
        return part.toString().trim();

    }

    private FAPackage parseFAndA(String dataLine) {
        StringBuilder part = new StringBuilder();
        for (int i = 43; i < 55; i++) {
            part.append(dataLine.charAt(i));
        }
        String[] split = part.toString().split("-");
        var f = Integer.parseInt(split[0].trim());
        var a = Integer.parseInt(split[1].trim());
        return new FAPackage(f, a);
    }


    @AllArgsConstructor
    @Getter
    private static class FAPackage {
        Integer f;
        Integer a;
    }
}
