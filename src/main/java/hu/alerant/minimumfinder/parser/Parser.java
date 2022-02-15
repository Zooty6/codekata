package hu.alerant.minimumfinder.parser;

public interface Parser<T> {
    T parse(String line);
    boolean isValidLine(String line);
}
