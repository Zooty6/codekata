package hu.alerant.minimumfinder;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class DataLoader {

    @SneakyThrows
    public List<String> load(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream contentStream = classLoader.getResourceAsStream(path);

        if (contentStream == null) {
            throw new NullPointerException("data file is missing: " + path);
        }

        String fileContent = new String(contentStream.readAllBytes(), StandardCharsets.UTF_8);
        String[] fileLines = fileContent.split("\n");
        contentStream.close();

        return Arrays.asList(fileLines);
    }
}
