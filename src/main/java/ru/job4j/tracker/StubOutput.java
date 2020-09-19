package ru.job4j.tracker;

/**
 * 9.1 Рефакторинг теста @Before @After [#285718]
 */
public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void print(Object obj) {
        if (obj != null) {
            buffer.append(obj.toString());
        } else {
            buffer.append("null");
        }
    }

    @Override
    public void printf(String format, Object... args) {
        buffer.append(String.format(format, args));
    }

    @Override
    public void println() {
        buffer.append(System.lineSeparator());
    }

    @Override
    public void println(Object obj) {
        print(obj);
        buffer.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
