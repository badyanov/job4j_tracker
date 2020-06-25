package ru.job4j.inheritance;

/**
 * 4. Переопределение [#285776]
 */
public class TextReport {
    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
