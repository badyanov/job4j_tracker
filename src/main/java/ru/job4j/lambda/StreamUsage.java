package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0.1. Отладка лямбда в IDEA [#285569]
 */
public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );

        // 1. Произведите рефакторинг кода по принципу строка занимает 80 символов.
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .map(task -> task.name)
                .forEach(System.out::println);

        // 2. Проанализируйте следующий код. Найдите в нем ошибку. Программа должна выводить задачи с scope > 30.
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " (" + task.spent + ")")
                .forEach(System.out::println);
    }
}
