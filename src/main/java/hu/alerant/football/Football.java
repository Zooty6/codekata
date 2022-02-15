package hu.alerant.football;

import hu.alerant.football.model.FootballData;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Football {
    private static final int HEADER_LINES = 1;

    public String getSmallestDifferenceTeam() {
        List<String> footballData = loadFile();
        return getMinimumTeam(footballData);
    }

    @SneakyThrows
    private List<String> loadFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream contentStream = classLoader.getResourceAsStream("football.dat");

        if (contentStream == null) {
            throw new NullPointerException("football data file is missing");
        }

        String fileContent = new String(contentStream.readAllBytes(), StandardCharsets.UTF_8);
        String[] fileLines = fileContent.split("\n");
        contentStream.close();

        return Arrays.asList(fileLines);
    }

    private String getMinimumTeam(List<String> footballData) {
        return footballData.stream()
                .skip(HEADER_LINES)
                .filter(Football::filterDataLines)
                .map(FootballData::new)
                .min(Football::compareByFAndA)
                .map(FootballData::getTeamName)
                .orElseThrow(Football::throwDataParseError);
    }

    private static int compareByFAndA(FootballData data1, FootballData data2) {
        Integer diff1 = Math.abs(data1.getA() - data1.getF());
        Integer diff2 = Math.abs(data2.getA() - data2.getF());
        return diff1.compareTo(diff2);
    }

    private static boolean filterDataLines(String s) {
        return !s.trim().startsWith("-");
    }

    private static IllegalArgumentException throwDataParseError() {
        return new IllegalArgumentException("Parsing data file failed");
    }
}
