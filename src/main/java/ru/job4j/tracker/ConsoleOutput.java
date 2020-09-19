package ru.job4j.tracker;

/**
 * 9.1 Рефакторинг теста @Before @After [#285718]
 */
public class ConsoleOutput implements Output {
    @Override
    public void print(Object obj) {
        System.out.print(obj);
    }

    @Override
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    @Override
    public void println() {
        System.out.println();
    }

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
