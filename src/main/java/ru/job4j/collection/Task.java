package ru.job4j.collection;

/**
 * 1. Уникальные задачи. [#285712]
 */
public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return description;
    }
}
