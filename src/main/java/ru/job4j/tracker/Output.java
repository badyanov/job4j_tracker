package ru.job4j.tracker;

/**
 * 9.1 Рефакторинг теста @Before @After [#285718]
 */
public interface Output {
    void print(Object obj);

    void printf(String format, Object ... args);

    void println();

    void println(Object obj);
}
