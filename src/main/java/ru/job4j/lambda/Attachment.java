package ru.job4j.lambda;

/**
 * 1. Анонимные классы [#285554]
 */
public class Attachment {
    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("{name='%s', size=%d}", name, size);
    }
}

